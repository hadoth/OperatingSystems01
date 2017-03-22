package process.automaticprocessgenerator.processbursttrend;

import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;

/**
 * Created by Karol on 2017-03-22.
 */
public interface ProcessBurstTrend {
    String getName();
    int[] generateBurstTime(int processCount, ProcessBurstTime burstTime);
}
