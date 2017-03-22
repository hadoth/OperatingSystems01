package process.automaticprocessgenerator.arrivaltimefrequency;

/**
 * Created by Karol on 2017-03-22.
 */
public class ClusterArrivals implements ArrivalTimeFrequency {
    @Override
    public String getName() {
        return "CLUSTERS";
    }

    @Override
    public int[] generateArrivalTime(int processCount) {
        int[] result = new int[processCount];
        int i = 0;
        int clusterTime = 0;
        int clusterSize;
        while (i < processCount){
            clusterSize = (int)(Math.random()*20);
            for (int j = 0; j < clusterSize; j++){
                result[i] = clusterTime + (int)(Math.random()*10);
                i++;
                if (i >= processCount) break;
            }
            clusterTime = clusterTime + (int)(Math.random()*400);
        }
        return result;
    }
}
