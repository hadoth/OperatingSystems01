package process;

import java.util.UUID;

/**
 * Created by Karol on 2017-03-19.
 */
public class ProcessBuilder {
    private UUID processId = UUID.randomUUID();
    private String processName = null;
    private int processArrivalTime = -1;
    private int processBurstTime = -1;
    private int processBurstTimeEstimate = -1;

    public ProcessBuilder withId(String processId){
        this.processId = UUID.fromString(processId);
        return this;
    }

    public ProcessBuilder withId(UUID processId){
        this.processId = processId;
        return this;
    }

    public ProcessBuilder withName(String processName){
        this.processName = processName;
        return this;
    }

    public ProcessBuilder withArrivalTime (int processArrivalTime){
        if (processArrivalTime < 0) throw new IllegalArgumentException("Arrival time must be greater than or equal to zero");
        this.processArrivalTime = processArrivalTime;
        return this;
    }

    public ProcessBuilder withBurstTime (int processBurstTime){
        if (processBurstTime <= 0) throw new IllegalArgumentException("Process Burst time must be greater than zero");
        this.processBurstTime = processBurstTime;
        return this;
    }

    public ProcessBuilder withBurstTimeEstimate(int processBurstTimeEstimate){
        if (processBurstTimeEstimate <= 0)
            throw new IllegalArgumentException("Estimated process burst time must be greater than zero");
        this.processBurstTimeEstimate = processBurstTimeEstimate;
        return this;
    }

    public Process build(){
        if (this.processArrivalTime < 0) throw new IllegalArgumentException("Arrival time not specified");
        if (this.processBurstTime <= 0) throw new IllegalArgumentException("Burst time not specified");
        if (this.processBurstTimeEstimate <= 0) this.processBurstTimeEstimate = this.processBurstTime;
        if (this.processName == null) throw new IllegalArgumentException("Process name not specified");
        return new Process(
                this.processId,
                this.processName,
                this.processArrivalTime,
                this.processBurstTime,
                this.processBurstTimeEstimate);
    }
}
