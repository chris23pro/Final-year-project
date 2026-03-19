import json
import random
import time
import paho.mqtt.client as mqtt

broker = "localhost"
port = 1883
topic = "iot/energy/power"

client = mqtt.Client()
client.connect(broker, port)

device_id = "power_monitor_001"

while True:

    voltage = round(random.uniform(220, 240), 2)
    current = round(random.uniform(0.5, 5.0), 2)

    power = round(voltage * current, 2)

    payload = {
        "device_id": device_id,
        "voltage": voltage,
        "current": current,
        "power": power,
        "unit": "watts",
        "timestamp": time.time()
    }

    client.publish(topic, json.dumps(payload))

    print("Published:", payload)

    time.sleep(5)
