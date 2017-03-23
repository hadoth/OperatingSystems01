package os;

import process.Process;
import processor.Processor;
import processor.ProcessorState;
import scheduler.Scheduler;
import utils.Clock;
import utils.Observer;

import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public class OperatingSystemImpl implements Observer, OperatingSystem {
    //input values
    private Clock systemClock;
    private Processor systemProcessor;
    private Scheduler systemScheduler;
    private ArrayList<Process> processQueue;
    private boolean consoleFlag;

    //process values
    private ArrayList<Process> processResults;

    public OperatingSystemImpl(
            Clock systemClock,
            Processor systemProcessor,
            Scheduler systemScheduler,
            ArrayList<Process> processQueue,
            boolean consoleFlag){
        this.systemClock = systemClock;
        this.systemProcessor = systemProcessor;
        this.systemScheduler = systemScheduler;
        this.processQueue = processQueue;
        this.consoleFlag = consoleFlag;

        this.processResults = new ArrayList<>();

        this.systemClock.addObserver(this);
        this.systemClock.addObserver(systemScheduler);
        this.systemClock.addObserver(systemProcessor);
    }

    public static OSBuilder builder(){
        return new OSBuilder();
    }

    @Override
    public void update(int time) {
        this.tick(time);
    }

    @Override
    public void generateReport(String path){
        //TODO: implement
    }

    @Override
    public void push(Process process){
        if (process.getBurstTime() != 0) throw new IllegalArgumentException("Used Process burst time must be equal to zero");
        this.processResults.add(process);
        if (this.consoleFlag)
            System.out.println(this.systemClock.getTime() + "\tfinish process; ID: " + this.processQueue.get(0).getProcessId());
    }

    private void tick(int time){
        boolean listChecked = false;
        do {
            if (this.processQueue.get(0).getProcessArrivalTime() == time){
                this.systemScheduler.push(this.processQueue.get(0));
                if (this.consoleFlag)
                    System.out.println(time + "\tload process; ID: " + this.processQueue.get(0).getProcessId());
                this.processQueue.remove(0);
            } else {
                listChecked = true;
            }
        } while(!listChecked && this.processQueue.size() > 0);
        if (this.processQueue.size() == 0 &&
                this.systemScheduler.isEmpty() &&
                this.systemProcessor.status() == ProcessorState.READY) {
            this.systemClock.stop();
        }
    }

    @Override
    public void run() {
        this.systemClock.start();
    }
}
