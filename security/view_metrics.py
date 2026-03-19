import sqlite3
from collections import defaultdict

print("\nIoT Security Metrics Analysis\n")

conn = sqlite3.connect("security_metrics.db")

cursor = conn.cursor()

cursor.execute("SELECT algorithm, execution_time FROM encryption_tests")

rows = cursor.fetchall()

conn.close()

if not rows:
    print("No metrics available.")
    exit()


# Store results by algorithm
results = defaultdict(list)

for algorithm, time_val in rows:
    results[algorithm].append(time_val)


print("Encryption Algorithm Performance Report")
print("--------------------------------------")


for algorithm in results:

    times = results[algorithm]

    avg_time = sum(times) / len(times)

    min_time = min(times)

    max_time = max(times)

    count = len(times)

    print(f"\nAlgorithm: {algorithm}")

    print(f"Tests Run: {count}")

    print(f"Average Time: {avg_time:.8f} seconds")

    print(f"Minimum Time: {min_time:.8f} seconds")

    print(f"Maximum Time: {max_time:.8f} seconds")


print("\nSecurity Evaluation Complete\n")

