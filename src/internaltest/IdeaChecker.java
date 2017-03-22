package internaltest;

import process.automaticprocessgenerator.ProcessGenerator;
import process.automaticprocessgenerator.arrivaltimefrequency.*;
import process.automaticprocessgenerator.bursttimeaccuracy.*;
import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;
import process.automaticprocessgenerator.processbursttrend.*;

/**
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class IdeaChecker {
    public static void main(String[] args) {
        ArrivalTimeFrequency[] arrivals = {new AllAtOnce(), new ClusterArrivals(), new ConstatntArrivalTime(), new RandomArrivalTime()};
        BurstTimeAccuracy[] est = {new HighlyRandomAccuracy(), new InMinus(), new InPlus(), new PerfectAccuracy(), new SlightlyRandomBurst()};
        ProcessBurstTime[] time = {ProcessBurstTime.EQUAL, ProcessBurstTime.GREATER, ProcessBurstTime.SMALLER};
        ProcessBurstTrend[] trend = {new ConstantBurstTime(), new ExponentialDecrease(), new ExponentialIncrease(), new HighlyRandomClass(), new LinearDecrement(), new LinearIncrement(), new OneHuge(), new SlighlyRandomBurst()};


        for (int i = 0; i < arrivals.length; i++){
            for (int j = 0; j < est.length; j++){
                for (int k = 0; k < time.length; k++){
                    for (int l = 0; l < trend.length; l++){
                        ProcessGenerator.makeProcessSeries()
                                .withProcessCount(100)
                                .withProcessBurstTime(time[k])
                                .withBurstTimeTrend(trend[l])
                                .withArrivalTimeFrequency(arrivals[i])
                                .withBurstTimeAccuracy(est[j])
                                .buildAndSave();
                    }
                }
            }
        }
    }
}
