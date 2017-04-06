package bootstrap;

import os.OperatingSystem;
import os.OperatingSystemImpl;
import process.Process;
import process.automaticprocessgenerator.ProcessGenerator;
import processor.Processor;
import scheduler.FcfsScheduler;
import scheduler.RrScheduler;
import scheduler.Scheduler;
import scheduler.SjfScheduler;
import utils.Clock;

import java.util.ArrayList;

/**
 * Created by Karol Pokomeda on 2017-03-23.
 */
public class Runtime {
    public static void main(String[] args){
        String loadPath = "GREATER_LININC_CONST_GOOD.csv";
        Clock systemClock = new Clock();
        Processor systemProcessor = new Processor();
        Scheduler systemScheduler = new FcfsScheduler();
//        Scheduler systemScheduler = new SjfScheduler(false);
//        Scheduler systemScheduler = new SjfScheduler(true);
//        Scheduler systemScheduler = new RrScheduler(66);
        OperatingSystem myOS =
            OperatingSystemImpl.builder()
                .withClock(systemClock)
                .withProcessor(systemProcessor)
                .withSystemScheduler(systemScheduler)
                .withProcessSource(loadPath)
                .withConsoleOutput()
                .build();
        myOS.run();
        String savePath = loadPath.replace(".csv", "_" + systemScheduler.getName() + ".txt");
        System.out.println(savePath);
        myOS.generateReport(savePath);
    }
}
