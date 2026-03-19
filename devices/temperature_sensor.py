import json
import random
import time
import paho.mqtt.client as mqtt

broker = "localhost"
port = 1883
topic = "iot/sensors/temperature"

client = mqtt.Client()
client.connect(broker, port)

device_id = "temp_sensor_001"

while True:

    temperature = round(random.uniform(18, 30), 2)

    payload = {
        "device_id": device_id,
        "temperature": temperature,
        "unit": "celsius",
        "timestamp": time.time()
    }

    client.publish(topic, json.dumps(payload))

    print("Published:", payload)

    time.sleep(5)


