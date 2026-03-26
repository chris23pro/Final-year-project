package models;

public class DeviceData {
    private String deviceType;
    private double value;
    private long timestamp;

    public DeviceData(String deviceType, double value, long timestamp) {
        this.deviceType = deviceType;
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getDeviceType() { return deviceType; }
    public double getValue() { return value; }
    public long getTimestamp() { return timestamp; }

    public void setDeviceType(String deviceType) { this.deviceType = deviceType; }
    public void setValue(double value) { this.value = value; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}