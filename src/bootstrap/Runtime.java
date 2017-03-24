package bootstrap;

import os.OperatingSystem;
import os.OperatingSystemImpl;
import process.Process;
import process.automaticprocessgenerator.ProcessGenerator;
import processor.Processor;
import scheduler.FcfsScheduler;
import scheduler.Scheduler;
import utils.Clock;

import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-03-23.
 */
public class Runtime {
    public static void main(String[] args){
        String loadPath = "EVENBIGGER_CONST_CONST_INMINUS.csv";
        String savePath = loadPath.replace("csv", "txt");
        Clock systemClock = new Clock();
        Processor systemProcessor = new Processor();
        Scheduler systemScheduler = new FcfsScheduler();
        OperatingSystem myOS =
            OperatingSystemImpl.builder()
                .withClock(systemClock)
                .withProcessor(systemProcessor)
                .withSystemScheduler(systemScheduler)
                .withProcessSource(loadPath)
                .withConsoleOutput()
                .build();
        myOS.run();
        myOS.generateReport(savePath);
    }
}
