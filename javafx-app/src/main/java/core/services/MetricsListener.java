package core.services;

import core.metrics.MetricIngestor;
import core.metrics.NormalizedMetrics;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.function.Consumer;

public class MetricsListener {
    private final MetricIngestor ingestor = new MetricIngestor();

    public void connectToBroker(String brokerUrl, Consumer<NormalizedMetrics> sink) throws MqttException {
        MqttClient client = new MqttClient(brokerUrl, MqttClient.generateClientId());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);

        client.setCallback(new MqttCallback() {
            @Override
            public void connectionLost(Throwable cause) {
                System.err.println("MQTT connection lost: " + cause.getMessage());
            }

            @Override
            public void messageArrived(String topic, MqttMessage message) {
                JSONObject payload = new JSONObject(new String(message.getPayload()));
                sink.accept(ingestor.ingest(payload));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) { }
        });

        client.connect(options);
        client.subscribe("iot/#");
    }
}
