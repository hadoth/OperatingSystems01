package process;

import java.util.UUID;

/**
 * Class stores basic process characteristics for CPU scheduling simulation
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class Process {
   private UUID processId;
    private String processName;
    private int processArrivalTime;
    private int burstTime;
    private int burstTimeEstimate;

    public Process(UUID processId, String processName, int processArrivalTime, int burstTime, int burstTimeEstimate){
        this.processId = processId;
        this.processName = processName;
        this.processArrivalTime = processArrivalTime;
        this.burstTime = burstTime;
        this.burstTimeEstimate = burstTimeEstimate;
    }

    public UUID getProcessId() {
        return processId;
    }

    public String getProcessName() {
        return processName;
    }

    public int getProcessArrivalTime() {
        return processArrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getBurstTimeEstimate() {
        return burstTimeEstimate;
    }

    public String toString(){
        return
                this.processId.toString() + ", " +
                this.processName + ", " +
                this.processArrivalTime + ", " +
                this.burstTime + ", " +
                this.burstTimeEstimate + ",";
    }
}