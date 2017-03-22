package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public class InPlus implements BurstTimeAccuracy {
    @Override
    public String getName() {
        return "INPLUS";
    }

    @Override
    public int[] generateBurstTimeEst(int[] burstTime) {
        int[] result = new int[burstTime.length];
        for (int i = 0; i < burstTime.length; i++) result[i] = (int)(burstTime[i]*1.5);
        return result;
    }
}
