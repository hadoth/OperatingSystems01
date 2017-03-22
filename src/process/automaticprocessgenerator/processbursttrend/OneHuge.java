package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public class OneHuge implements ProcessBurstTrend {
    @Override
    public String getName() {
        return "ONEBIG";
    }

    @Override
    public int[] generateBurstTime(int processCount, ProcessBurstTime burstTime) {
        int[] result = new int[processCount];
        for (int i = 0; i < processCount; i++) result[i] = (i == processCount/10) ? burstTime.getValue()*500 : burstTime.getValue();
        return result;
    }
}
