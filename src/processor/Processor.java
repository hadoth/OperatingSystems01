package processor;
import process.Process;
import process.ProcessImpl;
import utils.Observable;
import utils.Observer;

import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by KarolPokomeda on 2017-03-14.
 */
public class Processor implements Observer {
    private Process process;
    private ProcessorState processorStatus;

    public Processor(){
        this.process = null;
        this.processorStatus = ProcessorState.READY;
    }

    public ProcessorState status() {
        return this.processorStatus;
    }

    @Override
    public void update(int time) {
        this.tick(time);
    }

    private void tick(int time){
        this.process.tick(time);
        if (this.process.getBurstTime() == 0) {
            this.process.endProcess(time);
            if (this.process instanceof ProcessImpl)this.processorStatus = ProcessorState.FINISHED;
            else this.processorStatus = ProcessorState.READY;
        }
    }

    public void pushProcess(Process newProcess){
        if (this.processorStatus != ProcessorState.READY) throw new IllegalArgumentException("Processor is not ready");
        if (!(this.process instanceof ProcessSwap)  && this.process != null) throw new IllegalArgumentException("Processor is used by other process");
        this.process = newProcess;
        this.processorStatus = ProcessorState.PROCESSING;
    }

    public ProcessImpl pullProcess(int time){
        ProcessImpl oldProcess = (ProcessImpl) this.process;
        this.process = new ProcessSwap();
        this.processorStatus = ProcessorState.CONTEXT_SWAP;
        return oldProcess;
    }

    private class ProcessSwap extends Process{
        ProcessSwap(){
            super(UUID.randomUUID(), 10, 10);
        }
    }
}
