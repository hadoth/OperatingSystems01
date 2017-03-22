package processor;

/**
 * Created by Karol on 2017-03-19.
 */
public class ProcessEvent{
    private int currentTime;
    private ProcessorState processorState;

    public ProcessEvent(int currentTime, ProcessorState processorState){
        this.currentTime = currentTime;
        this.processorState = processorState;
    }

    public ProcessorState getProcessorState(){
        return this.processorState;
    }

    public int getCurrentTime(){
        return this.currentTime;
    }
}
