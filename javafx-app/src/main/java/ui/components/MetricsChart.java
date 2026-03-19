package ui.components;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class MetricsChart extends LineChart<Number, Number> {

    public MetricsChart() {
        super(new NumberAxis(), new NumberAxis());
        setTitle("Telemetry Trends: Latency and Crypto Time");

        XYChart.Series<Number, Number> latency = new XYChart.Series<>();
        latency.setName("Latency (ms)");
        latency.getData().add(new XYChart.Data<>(1, 82));
        latency.getData().add(new XYChart.Data<>(2, 85));
        latency.getData().add(new XYChart.Data<>(3, 79));

        XYChart.Series<Number, Number> crypto = new XYChart.Series<>();
        crypto.setName("Crypto Time (ms)");
        crypto.getData().add(new XYChart.Data<>(1, 11));
        crypto.getData().add(new XYChart.Data<>(2, 12));
        crypto.getData().add(new XYChart.Data<>(3, 9));

        getData().addAll(latency, crypto);
    }
}
