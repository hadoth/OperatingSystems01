package scheduler;

import os.OperatingSystem;
import process.ProcessImpl;
import processor.Processor;
import utils.Observer;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public interface Scheduler extends Observer {
    void setProcessor(Processor systemProcessor);

    void setOS(OperatingSystem parentOS);

    void push(ProcessImpl process);
    boolean isEmpty();
    String getName();
}
