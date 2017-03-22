package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public class InMinus implements BurstTimeAccuracy {
    @Override
    public String getName() {
        return "INMINUS";
    }

    @Override
    public int[] generateBurstTimeEst(int[] burstTime) {
        int[] result = new int[burstTime.length];
        for (int i = 0; i < burstTime.length; i++) {
            result[i] = (int)(burstTime[i]*0.5);
            result[i] = result[i] < 1 ? 1 : result[i];
        }
        return result;
    }
}
