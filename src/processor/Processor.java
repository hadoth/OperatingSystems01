package processor;
import process.Process;
import utils.Observable;
import utils.Observer;

import java.util.ArrayList;

/**
 * Created by KarolPokomeda on 2017-03-14.
 */
public class Processor implements Observable {
    private Process process = null;
    private ProcessorState processorStatus;
    private boolean isOn;
    private ArrayList<Observer> observerList = new ArrayList<Observer>();
    private int processorTime;

    private Processor(){
        this.processorStatus = ProcessorState.READY;
        this.processorTime = 0;
    }

    public void start(){

    }

//    public Process setProcess(){
//
//    }

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

//    @Override
//    public void nofifyObservers(ProcessEvent event) {
//        for (int i = 0; i < this.observerList.size(); i++) this.observerList.get(i).update(event);
//    }
}
