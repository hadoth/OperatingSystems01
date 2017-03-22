package process.automaticprocessgenerator.arrivaltimefrequency;

import java.util.ArrayList;

/**
 * Created by Karol on 2017-03-22.
 */
public interface ArrivalTimeFrequency {
    String getName();
    int[] generateArrivalTime(int processCount);
}
