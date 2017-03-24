package scheduler;

import os.OperatingSystem;
import process.Process;
import processor.ProcessEvent;
import processor.Processor;
import processor.ProcessorState;

import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public class FcfsScheduler implements Scheduler {
    private ArrayList<Process> waitingList;
    private Processor scheduledProcessor;
    private OperatingSystem parentSystem;

    public FcfsScheduler(Processor systemProcessor) {

    }

    @Override
    public void setOS(OperatingSystem parentOS) {
        this.parentSystem = parentOS;
    }

    @Override
    public void setProcessor(Processor systemProcessor) {
        this.scheduledProcessor = systemProcessor
    }

    @Override
    public void push(Process process) {
        this.waitingList.add(process);
    }

    @Override
    public boolean isEmpty() {
        return this.waitingList.size() == 0;
    }

    @Override
    public void update(int time) {
        if (this.scheduledProcessor.status() == ProcessorState.WAITING){
            Process finished = this.scheduledProcessor.pull();
            parentSystem.push(finished);
        } else if(this.scheduledProcessor.status() == ProcessorState.READY){
            this.scheduledProcessor.push(this.waitingList.get(0));
            this.waitingList.remove(0);
        }
    }
}