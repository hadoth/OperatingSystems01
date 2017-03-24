package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class LinearIncrement implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "LININC";
    }

    @Override
    public String getFullName() {
        return "Burst time linearly increase";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = (int)(burstTime.getValue()+burstTime.getValue()*i/100.0);
        return result;
    }
}
