package views;

import services.MQTTService;

/**
 * Console-based dashboard view.
 * Replaces JavaFX dependencies so the project can run in minimal setups.
 */
public class DashboardView {

    private final MQTTService mqttService;

    public DashboardView() {
        this.mqttService = new MQTTService();
    }

    public void start() {
        System.out.println("=======================================");
        System.out.println("      IoT Security Dashboard (CLI)     ");
        System.out.println("=======================================");

        boolean connected = mqttService.connect("tcp://localhost:1883", this::renderData);
        if (!connected) {
            System.out.println("Dashboard started, but MQTT connection is unavailable.");
            return;
        }

        System.out.println("Dashboard running successfully.");
    }

    private void renderData(String message) {
        System.out.println("[Dashboard] " + message);
    }
}
