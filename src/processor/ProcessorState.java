package processor;

/**
 * Created by KarolPokomeda on 2017-03-19.
 */
public enum ProcessorState {
    READY (0),
    PROCESSING(1),
    CONTEXT_SWAP(2),
    SCHEDULING(3),
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
