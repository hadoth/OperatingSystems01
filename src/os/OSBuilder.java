package os;

import process.Process;
import processor.Processor;
import scheduler.Scheduler;

import java.util.ArrayList;

/**
 * Created by Karol on 2017-03-19.
 */
public class OSBuilder {
    private ArrayList<Process> processList;
    private Scheduler internalScheduler;
    private boolean consoleOnFlag = false;
    private Processor systemProcessor;

    public OSBuilder withProcesses(ArrayList<Process> processList){
        this.processList = processList;
        return this;
    }

//    public OSBuilder withProcessesPath(String filePath){
//        this.processList = this.loadProcess(filePath);
//        return this;
//    }

    public OSBuilder withInternalScheduler(Scheduler internalScheduler){
        this.internalScheduler = internalScheduler;
        return this;
    }

    public OSBuilder withProcessor(Processor systemProcessor){
        this.systemProcessor = systemProcessor;
        return this;
    }

    public OSBuilder withConsoleOutput(){
        this.consoleOnFlag = true;
        return this;
    }

//    public OperatingSystem build(){
//        return new OperatingSystemImplementation(this.systemProcessor, this.internalScheduler, this.processList, this.consoleOnFlag);
//    }

//    private ArrayList<Process> loadProcess(String filePath){
//        ArrayList<Process> result = new ArrayList<>();
//
//    }
}
