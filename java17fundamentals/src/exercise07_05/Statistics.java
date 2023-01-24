package exercise07_05;

public class Statistics {

    public static int average(int... values) {
        int total = 0;
        for (int el: values) {
            total += el;
        }
        int avg = 0;
        if (values.length != 0) {
            avg = total / values.length;
        }
        return avg;
    }

    public static int min(int... values) {
        int min = values[0];
        for (int i=1;i<values.length;i++) {
            if (values[i] < min) min = values[i];
        }
        return min;
    }
    public static int max(int... values) {
        int max = values[0];
        for (int i=1;i<values.length;i++) {
            if (values[i] > max) max = values[i];
        }
        return max;
    }
}
