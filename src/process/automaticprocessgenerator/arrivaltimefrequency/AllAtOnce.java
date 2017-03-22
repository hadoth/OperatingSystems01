package process.automaticprocessgenerator.arrivaltimefrequency;

/**
 * Created by Karol on 2017-03-22.
 */
public class AllAtOnce implements ArrivalTimeFrequency {
    @Override
    public String getName() {
        return "ATONCE";
    }

    @Override
    public int[] generateArrivalTime(int processCount) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = 0;
        return result;
    }
}
