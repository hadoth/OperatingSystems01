package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class HighlyRandomClass implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "RAND100";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++){
            result[i] = (int)(Math.random()*burstTime.getValue()*2);
            result[i] = result[i] < 1 ? 1 : result[i];

        }
        return result;
    }
}
