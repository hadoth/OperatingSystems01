package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class ExponentialIncrease implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "EXPINC";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = (int)(burstTime.getValue() * Math.exp(i/42.0));
        return result;
    }
}
