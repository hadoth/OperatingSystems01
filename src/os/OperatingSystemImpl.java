package os;

import process.ProcessImpl;
import processor.Processor;
import processor.ProcessorState;
import scheduler.Scheduler;
import utils.Clock;
import utils.Observer;
import utils.Statistics;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public class OperatingSystemImpl implements Observer, OperatingSystem {
    //input values
    private Clock systemClock;
    private Processor systemProcessor;
    private Scheduler systemScheduler;
    private ArrayList<ProcessImpl> processQueue;
    private boolean consoleFlag;

    //process values
    private ArrayList<ProcessImpl> processResults;

    public OperatingSystemImpl(
            Clock systemClock,
            Processor systemProcessor,
            Scheduler systemScheduler,
            ArrayList<ProcessImpl> processQueue,
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

        this.systemScheduler.setOS(this);
        this.systemScheduler.setProcessor(this.systemProcessor);
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
        int counter = this.processResults.size();
        int[] waitTime = new int[counter];
        int[] responseTime = new int[counter];
        int[] turnaroundTime = new int[counter];

        for (int i = 0; i < counter; i++){
            waitTime[i] = this.processResults.get(i).getWaitTime();
            responseTime[i] = this.processResults.get(i).getResponseTime();
            turnaroundTime[i] = this.processResults.get(i).getTurnaroundTime();
        }

        double waitTimeMean = Statistics.meanValue(waitTime);
        double waitTimeDeviation = Statistics.standardDeviation(waitTime);
        int waitTimeMax = Statistics.maxValue(waitTime);
        double responseTimeMean = Statistics.meanValue(responseTime);
        double responseTimeDeviation = Statistics.standardDeviation(responseTime);
        int responseTimeMax = Statistics.maxValue(responseTime);
        double turnaroundTimeMean = Statistics.meanValue(turnaroundTime);
        double turnaroundTimeDeviation = Statistics.standardDeviation(turnaroundTime);
        int turnaroundTimeMax = Statistics.maxValue(turnaroundTime);

        File myFile = new File(path);
        try (
                FileWriter fileOut = new FileWriter(myFile);
                PrintWriter dataOut = new PrintWriter(fileOut)
        ){
            myFile.createNewFile();

            String[] description = path.replace(".txt", "").split("_");


            dataOut.println("PROCESSOR REPORT");
            dataOut.println();
            dataOut.println("Scheduler:\t\t\t" + description[4]);
            dataOut.println("Data burst base:\t\t" + description[0]);
            dataOut.println("Data burst trend :\t\t" + description[1]);
            dataOut.println("Arrival time schema :\t\t" + description[2]);
            dataOut.println("Burst time est. accuracy :\t" + description[3]);
            dataOut.println();
            dataOut.printf("Mean wait time:\t\t\t%.3f +- %.3f (MAX: %d)", waitTimeMean, waitTimeDeviation, waitTimeMax);
            dataOut.println();
            dataOut.printf("Mean response time:\t\t%.3f +- %.3f (MAX: %d)", responseTimeMean, responseTimeDeviation, responseTimeMax);
            dataOut.println();
            dataOut.printf("Mean trunaround time:\t\t%.3f +- %.3f (MAX: %d)", turnaroundTimeMean, turnaroundTimeDeviation, turnaroundTimeMax);


            if (fileOut != null) fileOut.close();
            if (dataOut != null) dataOut.close();
        } catch (IOException e){
        }
    }

    @Override
    public void push(ProcessImpl process){
        if (process.getBurstTime() != 0) throw new IllegalArgumentException("Used Process burst time must be equal to zero");
        this.processResults.add(process);
        if (this.consoleFlag)
            System.out.println(this.systemClock.getTime() + "\tfinish process; ID: " + process.getProcessId());
    }

    private void tick(int time){
        boolean listChecked = false;
        do {
            if (!this.processQueue.isEmpty() && this.processQueue.get(0).getProcessArrivalTime() == time){
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
