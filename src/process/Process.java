package process;


import java.util.UUID;

/**
 * Created by Karol on 2017-03-24.
 */
public abstract class Process {
    private int burstTime;
    private int burstTimeEstimate;
    private UUID processId;

    public Process(UUID processId, int burstTime, int burstTimeEst){
        this.processId = processId;
        this.burstTime = burstTime;
        this.burstTimeEstimate = burstTimeEst;
    }

    public void tick(int time){
        this.burstTime--;
        if (this.burstTimeEstimate > 0) this.burstTimeEstimate--;
    }

    public UUID getProcessId() {
        return this.processId;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getBurstTimeEstimate() {
        return burstTimeEstimate;
    }

    public void endProcess(int processorTime){
    }
}
