import json
import time

LOG_FILE = "../logs/iot_data_log.txt"

print("Security Evaluation Engine Running...")

def evaluate_temperature(temp):

    if temp > 35:
        return "CRITICAL"

    elif temp > 25:
        return "WARNING"

    else:
        return "NORMAL"


def evaluate_power(power):

    if power > 1000:
        return "HIGH"

    elif power > 500:
        return "MEDIUM"

    else:
        return "LOW"


def evaluate_control(state):

    if state == "ON":
        return "DEVICE ACTIVE"

    else:
        return "DEVICE OFF"


while True:

    try:

        with open(LOG_FILE) as f:
            lines = f.readlines()

        if len(lines) == 0:
            time.sleep(2)
            continue

        last_line = lines[-1]

        parts = last_line.split("|")

        if len(parts) < 3:
            continue

        payload = parts[2].strip()

        msg = json.loads(payload)

        if "temperature" in msg:

            result = evaluate_temperature(msg["temperature"])

            print("Temperature:", msg["temperature"], "Status:", result)


        if "power" in msg:

            result = evaluate_power(msg["power"])

            print("Power:", msg["power"], "Status:", result)


        if "device_state" in msg:

            result = evaluate_control(msg["device_state"])

            print("Control State:", msg["device_state"], "Status:", result)


        time.sleep(2)

    except Exception as e:

        print("Evaluation Error:", e)

        time.sleep(2)
