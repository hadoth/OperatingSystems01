package process;

import java.util.UUID;

/**
 * Class stores basic process characteristics for CPU scheduling simulation
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class Process {
   private UUID processId;
    private int processArrivalTime;
    private int burstTime;
    private int burstTimeEstimate;
    private int burstStartTime;
    private boolean started = false;
    private int burstEndTime;
    private boolean finished = false;
    private int firstResultTime;
    private boolean firstResultDone = false;

    public Process(UUID processId, int processArrivalTime, int burstTime, int burstTimeEstimate){
        this.processId = processId;
        this.processArrivalTime = processArrivalTime;
        this.burstTime = burstTime;
        this.burstTimeEstimate = burstTimeEstimate;
    }

    public void tick(){
        this.burstTime--;
        if (this.burstTimeEstimate > 0) this.burstTimeEstimate--;
    }

    public UUID getProcessId() {
        return processId;
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

    public boolean isStarted(){
        return this.started;
    }

    public void startProcess(int processorTime){
        this.started = true;
        this.burstStartTime = processorTime;
    }

    public boolean isFinished(){
        return this.finished;
    }

    public void endProcess(int processorTime){
        this.finished = true;
        this.burstEndTime = processorTime;
    }

    public boolean isFirstResultDone(){
        return this.firstResultDone;
    }

    public void finishFirstPart(int processorTime){
        this.firstResultDone = true;
        this.firstResultTime = processorTime;
    }

    public String toString(){
        return
                this.processId.toString() + ", " +
                this.processArrivalTime + ", " +
                this.burstTime + ", " +
                this.burstTimeEstimate + ", ";
    }

    public int getWaitTime(){
        return this.burstStartTime - this.processArrivalTime;
    }

    public int getResponseTime(){
        return this.firstResultTime - this.processArrivalTime;
    }

    public int getTurnaroundTime(){
        return this.burstEndTime - this.processArrivalTime;
    }
}