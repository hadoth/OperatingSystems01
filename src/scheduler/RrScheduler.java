package scheduler;

import os.OperatingSystem;
import process.ProcessImpl;
import processor.Processor;
import processor.ProcessorState;

import java.util.ArrayList;

/**
 * Created by Karol on 2017-03-24.
 */
public class RrScheduler implements Scheduler {
    private ArrayList<ProcessImpl> waitingList;
    private OperatingSystem parentOS;
    private Processor systemProcessor;
    private int timeQuantum;
    private int countdown;

    public RrScheduler(int timeQuantum){
        this.waitingList = new ArrayList<>();
        this.timeQuantum = timeQuantum;
        this.countdown = timeQuantum;
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
        this.waitingList.add(process);
    }

    @Override
    public boolean isEmpty() {
        return this.waitingList.size() == 0;
    }

    @Override
    public String getName() {
        return "RR" + this.timeQuantum;
    }

    private void tick (int time){
        if (this.systemProcessor.status() == ProcessorState.FINISHED) {
            ProcessImpl process = this.systemProcessor.pullProcess(time);
            process.finishFirstPart(time);
            this.parentOS.push(process);
        }
        if (this.systemProcessor.status() == ProcessorState.READY && !this.isEmpty()) {
            ProcessImpl processToSchedule = this.waitingList.remove(0);
            processToSchedule.startProcess(time);
            this.systemProcessor.pushProcess(processToSchedule);
            this.countdown = this.timeQuantum;
        }
        if (this.systemProcessor.status() == ProcessorState.PROCESSING){
            this.countdown--;
            if (this.countdown == 0){
                this.countdown = this.timeQuantum;
                ProcessImpl process = this.systemProcessor.pullProcess(time);
                process.finishFirstPart(time);
                this.waitingList.add(process);
            }
        }
    }
}