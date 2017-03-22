package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class SlighlyRandomBurst implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "RAND020";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++){
            result[i] = (int)(burstTime.getValue() - burstTime.getValue()*0.2  + Math.random()*burstTime.getValue()*0.4);
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
