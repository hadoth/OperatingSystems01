package scheduler;

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

    @Override
    public void update(ProcessEvent event) {
        if (event.equals(ProcessorState.READY) && this.waitingList.size() > 0){
            //this.scheduledProcessor.setProcess(this.waitingList.remove(0));
        }
    }

    @Override
    public void addProcess(Process newProcess) {
        this.waitingList.add(newProcess);
    }
}
