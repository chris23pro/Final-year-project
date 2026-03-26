package utils;

public class MathUtils {
    public static double average(double[] values) {
        double sum = 0;
        for (double v : values) sum += v;
        return values.length > 0 ? sum / values.length : 0;
    }
}
