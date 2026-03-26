package services;

import java.util.UUID;
import java.util.function.Consumer;

/**
 * Lightweight MQTT service wrapper that runs without external dependencies.
 *
 * <p>If Eclipse Paho is available on the classpath, this class can be extended
 * later to perform a real connection. For now it provides safe, non-crashing
 * behavior so the app can start in every environment.</p>
 */
public class MQTTService {

    private final String clientId;
    private boolean connected;

    public MQTTService() {
        this.clientId = "JavaClient-" + UUID.randomUUID();
        this.connected = false;
    }

    /**
     * Attempts to connect to MQTT in a safe way.
     * Current implementation runs in offline/demo mode and reports status.
     */
    public boolean connect(String brokerUrl, Consumer<String> onData) {
        String safeBrokerUrl = (brokerUrl == null || brokerUrl.isBlank())
                ? "tcp://localhost:1883"
                : brokerUrl.trim();

        System.out.println("[MQTT] Starting client: " + clientId);
        System.out.println("[MQTT] Broker: " + safeBrokerUrl);

        try {
            // Demo mode so program remains runnable without external MQTT libraries.
            connected = true;
            if (onData != null) {
                onData.accept("Connected in demo mode. Waiting for IoT messages...");
            }
            System.out.println("[MQTT] Connected (demo mode).");
            return true;
        } catch (Exception ex) {
            connected = false;
            String message = "[MQTT] Connection failed: " + ex.getMessage();
            System.err.println(message);
            if (onData != null) {
                onData.accept(message);
            }
            return false;
        }
    }

    public boolean isConnected() {
        return connected;
    }

    public void disconnect() {
        if (connected) {
            connected = false;
            System.out.println("[MQTT] Disconnected.");
        }
    }
}
