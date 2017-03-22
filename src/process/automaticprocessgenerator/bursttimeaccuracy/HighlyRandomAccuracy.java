package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public class HighlyRandomAccuracy implements BurstTimeAccuracy {
    @Override
    public String getName() {
        return "RANDOM100";
    }

    @Override
    public int[] generateBurstTimeEst(int[] burstTime) {
        int[] result = new int[burstTime.length];
        for (int i = 0; i < burstTime.length; i++) {
            result[i] = (int)(Math.random()*burstTime[i]*2);
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
