package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class ExponentialDecrease implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "EXPDEC";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) {
            result[i] = (int)(burstTime.getValue() * Math.exp((100 - i)/42.0));
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
