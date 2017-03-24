package processor;
import process.Process;
import utils.Observable;
import utils.Observer;

import java.util.ArrayList;

/**
 * Created by KarolPokomeda on 2017-03-14.
 */
public class Processor implements Observable, Observer {
    private Process process = null;
    private ProcessorState processorStatus;
    private boolean isOn;
    private ArrayList<Observer> observerList = new ArrayList<Observer>();
    private int processorTime;

    public Processor(){
        this.processorStatus = ProcessorState.READY;
    }

    public void start(){

    }

    @Override
    public void addObserver(Observer observer) {
        if (this.observerList.indexOf(observer) < 0) this.observerList.add(observer);
    }

    @Override
    public boolean deleteObserver(Observer observer) {
        if (this.observerList.indexOf(observer) >= 0){
            return this.observerList.remove(observer);
        }
        return false;
    }

    public ProcessorState status() {
        return this.processorStatus;
    }

    @Override
    public void update(int time) {
        this.tick(time);
    }

    private void tick(int time){

    }
}
