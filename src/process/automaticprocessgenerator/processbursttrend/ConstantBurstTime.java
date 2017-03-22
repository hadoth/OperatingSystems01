package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class ConstantBurstTime implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "CONST";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = burstTime.getValue();
        return result;
    }
}
