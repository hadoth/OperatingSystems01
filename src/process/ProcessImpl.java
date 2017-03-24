package process;

import java.util.UUID;

/**
 * Class stores basic process characteristics for CPU scheduling simulation
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class ProcessImpl extends Process {
    private int processArrivalTime;
    private int burstStartTime;
    private boolean started = false;
    private int burstEndTime;
    private boolean finished = false;
    private int firstResultTime;
    private boolean firstResultDone = false;

    public ProcessImpl(UUID processId, int processArrivalTime, int burstTime, int burstTimeEstimate){
        super(processId, burstTime, burstTimeEstimate);
        this.processArrivalTime = processArrivalTime;
    }


    public int getProcessArrivalTime() {
        return processArrivalTime;
    }

    public boolean isStarted(){
        return this.started;
    }

    public void startProcess(int processorTime){
        if (!this.isStarted()) {
            this.started = true;
            this.burstStartTime = processorTime;
        }
    }

    public boolean isFinished(){
        return this.finished;
    }

    public void endProcess(int processorTime){
        if (!this.isFinished()) {
            this.finished = true;
            this.burstEndTime = processorTime;
        }
    }

    public boolean isFirstResultDone(){
        return this.firstResultDone;
    }

    public void finishFirstPart(int processorTime){
        if (!this.isFirstResultDone()) {
            this.firstResultDone = true;
            this.firstResultTime = processorTime;
        }
    }

    public String toString(){
        return
                super.getProcessId().toString() + ", " +
                this.processArrivalTime + ", " +
                super.getBurstTime() + ", " +
                super.getBurstTimeEstimate() + ", ";
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