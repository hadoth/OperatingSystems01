package process.automaticprocessgenerator.arrivaltimefrequency;

/**
 * Created by Karol on 2017-03-22.
 */
public class ConstatntArrivalTime implements ArrivalTimeFrequency {
    @Override
    public String getName() {
        return "CONST";
    }

    @Override
    public String getFullName() {
        return "Constant time between process arrivals";
    }

    @Override
    public int[] generateArrivalTime(int processCount) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = i*20;
        return result;
    }
}
