package os;

import process.Process;
import process.ProcessImpl;
import processor.Processor;
import scheduler.Scheduler;
import utils.Clock;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

/**
 * Created by Karol on 2017-03-19.
 */
public class OSBuilder {
    private Clock systemClock;
    private Processor systemProcessor;
    private Scheduler systemScheduler;
    private ArrayList<ProcessImpl> processQueue;
    private boolean consoleFlag = false;

    public OSBuilder withProcesses(ArrayList<ProcessImpl> processQueue){
        this.processQueue = processQueue;
        return this;
    }

    public OSBuilder withProcessSource(String filePath){
        ArrayList<ProcessImpl> result = new ArrayList<>();
        File inputFile = new File(filePath);
        try(FileReader fileIn = new FileReader(inputFile);
                Scanner dataIn = new Scanner(fileIn)){
            while(dataIn.hasNextLine()){
                String[] processText = dataIn.nextLine().split(", ");
                result.add(new ProcessImpl(
                        UUID.fromString(processText[0]),
                        Integer.parseInt(processText[1]),
                        Integer.parseInt(processText[2]),
                        Integer.parseInt(processText[3])));
            }
            this.processQueue = result;
        } catch (IOException e){
            throw new IllegalArgumentException("File not found or data corrupted");
        }
        return this;
    }

    public OSBuilder withClock(Clock systemClock){
        this.systemClock = systemClock;
        return this;
    }

    public OSBuilder withSystemScheduler(Scheduler systemScheduler){
        this.systemScheduler = systemScheduler;
        return this;
    }

    public OSBuilder withProcessor(Processor systemProcessor){
        this.systemProcessor = systemProcessor;
        return this;
    }

    public OSBuilder withConsoleOutput(){
        this.consoleFlag = true;
        return this;
    }

    public OperatingSystemImpl build(){
        return new OperatingSystemImpl(
                this.systemClock,
                this.systemProcessor,
                this.systemScheduler,
                this.processQueue,
                this.consoleFlag
        );
    }
}
