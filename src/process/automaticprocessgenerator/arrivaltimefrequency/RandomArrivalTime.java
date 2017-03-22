package process.automaticprocessgenerator.arrivaltimefrequency;

/**
 * Created by Karol on 2017-03-22.
 */
public class RandomArrivalTime implements ArrivalTimeFrequency {
    @Override
    public String getName() {
        return "RAND";
    }

    @Override
    public int[] generateArrivalTime(int processCount) {
        int[] result = new int[processCount];
        result[0] = 0;
        for (int i = 1; i < processCount; i++) result[i] = result[i-1] + (int)(Math.random()*50);
        return result;
    }
}
