package processor;

/**
 * Created by KarolPokomeda on 2017-03-19.
 */
public enum ProcessorState {
    READY (0),
    WAITING(1),
    PROCESSING(2),
    CONTEXT_SWAP(3),
    SCHEDULING(4),
    PROCESS_ERROR(-1);

    private int stateCode;

    ProcessorState(int stateCode){
        this.stateCode = stateCode;
    }

    public int getStateCode(){
        return this.stateCode;
    }

    public boolean equals(ProcessorState otherState){
        return(this.getStateCode() == otherState.getStateCode());
    }
}
