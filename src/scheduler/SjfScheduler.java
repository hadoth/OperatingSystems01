package scheduler;

import os.OperatingSystem;
import process.ProcessImpl;
import processor.Processor;
import processor.ProcessorState;

import java.util.ArrayList;

/**
 * Created by Karol on 2017-03-24.
 */
public class SjfScheduler implements Scheduler {
    private ArrayList<ProcessImpl> waitingList;
    private OperatingSystem parentOS;
    private Processor systemProcessor;
    private boolean withPremption;


    public SjfScheduler(boolean withPremption){
        this.waitingList = new ArrayList<>();
        this.withPremption = withPremption;
    }

    @Override
    public void update(int time) {
        this.tick(time);
    }

    @Override
    public void setProcessor(Processor systemProcessor){
        this.systemProcessor = systemProcessor;
    }

    @Override
    public void setOS(OperatingSystem parentOS){
        this.parentOS = parentOS;
    }

    @Override
    public void push(ProcessImpl process) {
        int i = 0;
        boolean isUnsorted = true;
        while(isUnsorted && i < this.waitingList.size()){
            if (this.waitingList.get(i).getBurstTimeEstimate() > process.getBurstTimeEstimate()){
                this.waitingList.add(i, process);
                isUnsorted = false;
            }
            i++;
        }
        if (isUnsorted) this.waitingList.add(process);
    }

    @Override
    public boolean isEmpty() {
        return this.waitingList.size() == 0;
    }

    @Override
    public String getName() {
        if (this.withPremption) return "SJFP";
        return "SJF";
    }

    private void tick(int time){
        if (this.withPremption &&
                this.systemProcessor.status() == ProcessorState.PROCESSING &&
                !this.isEmpty() &&
                this.systemProcessor.burstEstimate() > this.waitingList.get(0).getBurstTimeEstimate()){
            this.push(this.systemProcessor.pullProcess(time));
        }
        if (this.systemProcessor.status() == ProcessorState.FINISHED) {
            ProcessImpl process = this.systemProcessor.pullProcess(time);
            process.finishFirstPart(time);
            this.parentOS.push(process);
        }
        if (this.systemProcessor.status() == ProcessorState.READY && !this.isEmpty()) {
            ProcessImpl processToSchedule = this.waitingList.remove(0);
            processToSchedule.startProcess(time);
            this.systemProcessor.pushProcess(processToSchedule);
        }
    }
}
