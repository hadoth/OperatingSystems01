package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public class PerfectAccuracy implements BurstTimeAccuracy {
    @Override
    public String getName() {
        return "GOOD";
    }

    @Override
    public int[] generateBurstTimeEst(int[] bursTime) {
        return bursTime;
    }
}
