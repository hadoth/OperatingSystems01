package utils;

/**
 * Created by Karol on 2017-03-24.
 */
public class Statistics {
    public static double meanValue(int[] measurement){
        double sum = 0.0;
        for (int i = 0; i < measurement.length; i++) sum += measurement[i];
        return sum/measurement.length;
    }

    public static double standardDeviation(int[] measurement){
        double sum = 0.0;
        double mean = Statistics.meanValue(measurement);
        for (int i = 0; i < measurement.length; i++) sum += (mean - measurement[i]) * (mean - measurement[i]);
        return Math.sqrt(sum/measurement.length);

    }
}
