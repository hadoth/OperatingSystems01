package processor;

/**
 * Created by KarolPokomeda on 2017-03-19.
 */
public enum ProcessorState {
    READY (0),
    PDOCESSING_EXTERNAL(1),
    PROCESSING_INTERNAL(2),
    PROCESSOR_ERROR(-1);

    private int stateCode;

    ProcessorState(int stateCode){
        this.stateCode = stateCode;
    }

    public int getStateCode(){
        return this.stateCode;
    }
}
