import os
import time
import sqlite3
import matplotlib.pyplot as plt

from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.asymmetric import ec


print("\nStarting Automatic Encryption Experiment\n")


data = os.urandom(1024)

aes_results = []
chacha_results = []
ecc_results = []


experiments = 1000


for i in range(experiments):

    # AES TEST
    key = os.urandom(32)
    iv = os.urandom(16)

    start = time.time()

    cipher = Cipher(
        algorithms.AES(key),
        modes.CFB(iv),
        backend=default_backend()
    )

    encryptor = cipher.encryptor()

    ciphertext = encryptor.update(data) + encryptor.finalize()

    end = time.time()

    aes_time = end - start

    aes_results.append(aes_time)



    # ChaCha20 TEST
    key = os.urandom(32)
    nonce = os.urandom(16)

    start = time.time()

    algorithm = algorithms.ChaCha20(key, nonce)

    cipher = Cipher(algorithm, mode=None, backend=default_backend())

    encryptor = cipher.encryptor()

    ciphertext = encryptor.update(data)

    end = time.time()

    chacha_time = end - start

    chacha_results.append(chacha_time)



    # ECC TEST
    start = time.time()

    private_key = ec.generate_private_key(
        ec.SECP256R1(),
        default_backend()
    )

    public_key = private_key.public_key()

    end = time.time()

    ecc_time = end - start

    ecc_results.append(ecc_time)


print("Experiments Completed\n")


# DATABASE STORAGE

conn = sqlite3.connect("security_metrics.db")
cursor = conn.cursor()

cursor.execute("""
CREATE TABLE IF NOT EXISTS encryption_tests (
id INTEGER PRIMARY KEY AUTOINCREMENT,
algorithm TEXT,
execution_time REAL
)
""")


for t in aes_results:
    cursor.execute(
        "INSERT INTO encryption_tests (algorithm, execution_time) VALUES (?,?)",
        ("AES", t)
    )


for t in chacha_results:
    cursor.execute(
        "INSERT INTO encryption_tests (algorithm, execution_time) VALUES (?,?)",
        ("ChaCha20", t)
    )


for t in ecc_results:
    cursor.execute(
        "INSERT INTO encryption_tests (algorithm, execution_time) VALUES (?,?)",
        ("ECC", t)
    )


conn.commit()
conn.close()


print("Results stored in database")


# GRAPH GENERATION

labels = ["AES", "ChaCha20", "ECC"]

averages = [
sum(aes_results)/len(aes_results),
sum(chacha_results)/len(chacha_results),
sum(ecc_results)/len(ecc_results)
]


plt.bar(labels, averages)

plt.title("Encryption Algorithm Performance Comparison")

plt.ylabel("Average Execution Time (seconds)")

plt.xlabel("Encryption Algorithm")

plt.show()


