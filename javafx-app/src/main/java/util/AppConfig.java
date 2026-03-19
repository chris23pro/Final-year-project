package util;

public final class AppConfig {
    private AppConfig() {}

    public static final String SQLITE_URL = "jdbc:sqlite:../security/security_metrics.db";
    public static final String MQTT_BROKER_URL = "tcp://localhost:1883";
}
