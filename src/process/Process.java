package process;

import utils.Observer;

import java.util.UUID;

/**
 * Class stores basic process characteristics for CPU scheduling simulation
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class Process{
   private UUID processId;
    private int processArrivalTime;
    private int burstTime;
    private int burstTimeEstimate;
    private int burstStartTime;
    private boolean started;
    private int burstEndTime;
    private boolean finished;
    private int firstResultTime;
    private boolean firstResultDone ;

    public Process(UUID processId, int processArrivalTime, int burstTime, int burstTimeEstimate){
        this.processId = processId;
        this.processArrivalTime = processArrivalTime;
        this.burstTime = burstTime;
        this.burstTimeEstimate = burstTimeEstimate;
        this.started = false;
        this.finished = false;
        this.firstResultDone = false;
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

    public boolean isFinished(){
        return this.finished;
    }

    public boolean isFirstResultDone(){
        return this.firstResultDone;
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

    public void tick(int time){
        this.burstTime--;
        if (this.burstTimeEstimate > 0) this.burstTimeEstimate--;
    }

    public void startProcess(int processorTime){
        this.started = true;
        this.burstStartTime = processorTime;
    }

    public void endProcess(int processorTime){
        this.finished = true;
        this.burstEndTime = processorTime;
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
}