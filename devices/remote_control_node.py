import json
import random
import time
import paho.mqtt.client as mqtt

broker = "localhost"
port = 1883
topic = "iot/control/device"

client = mqtt.Client()
client.connect(broker, port)

device_id = "control_node_001"

states = ["ON","OFF"]

while True:

    state = random.choice(states)

    payload = {
        "device_id": device_id,
        "device_state": state,
        "timestamp": time.time()
    }

    client.publish(topic, json.dumps(payload))

    print("Control Message Sent:", payload)

    time.sleep(7)
