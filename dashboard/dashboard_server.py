	
from flask import Flask, render_template, jsonify
import json

app = Flask(__name__)

LOG_FILE = "../logs/iot_data_log.txt"

@app.route("/")
def home():
    return render_template("dashboard.html")


@app.route("/data")
def data():

    labels = []
    temps = []
    powers = []
    controls = []

    try:
        with open(LOG_FILE) as f:
            lines = f.readlines()

        last_lines = lines[-50:]

        for i, line in enumerate(last_lines):

            parts = line.split("|")

            if len(parts) < 3:
                continue

            payload = parts[2].strip()

            try:
                msg = json.loads(payload)

                if "temperature" in msg:
                    temps.append(msg["temperature"])
                    labels.append(i)

                if "power" in msg:
                    powers.append(msg["power"])

                if "device_state" in msg:
                    if msg["device_state"] == "ON":
                        controls.append(1)
                    else:
                        controls.append(0)

            except:
                pass

    except:
        pass

    return jsonify({
        "labels": labels,
        "temperature": temps,
        "power": powers,
        "controls": controls
    })


if __name__ == "__main__":
    app.run(host="0.0.0.0", port=5000)

