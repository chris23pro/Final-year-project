import paho.mqtt.client as mqtt
import datetime

broker = "localhost"
port = 1883
topic = "iot/#"

log_file = "../logs/iot_data_log.txt"

def on_message(client, userdata, msg):

    message = msg.payload.decode()

    timestamp = datetime.datetime.now()

    log_entry = f"{timestamp} | {msg.topic} | {message}\n"

    print(log_entry)

    with open(log_file, "a") as file:
        file.write(log_entry)

client = mqtt.Client()

client.on_message = on_message

client.connect(broker, port)

client.subscribe(topic)

print("IoT Logger Running...")

client.loop_forever()
