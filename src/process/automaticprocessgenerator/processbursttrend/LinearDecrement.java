package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class LinearDecrement implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "LINDEC";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) {
            result[i] = (int)(2*burstTime.getValue() - burstTime.getValue()*i/100.0);
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
