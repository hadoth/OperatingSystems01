package process.automaticprocessgenerator.bursttimeaccuracy;

/**
 * Created by Karol on 2017-03-22.
 */
public interface BurstTimeAccuracy {
    String getName();
    int[] generateBurstTimeEst(int[] bursTime);
}
