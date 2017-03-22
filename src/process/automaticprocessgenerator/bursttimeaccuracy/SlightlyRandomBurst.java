package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public class SlightlyRandomBurst implements BurstTimeAccuracy {
    @Override
    public String getName() {
        return "RANDOM020";
    }

    @Override
    public int[] generateBurstTimeEst(int[] burstTime) {
        int[] result = new int[burstTime.length];
        for (int i = 0; i < burstTime.length; i++) {
            result[i] = (int)(burstTime[i] - burstTime[i]*0.2 + Math.random()*burstTime[i]*0.4);
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
