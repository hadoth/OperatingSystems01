package scheduler;

import os.OperatingSystem;
import process.Process;
import processor.Processor;
import utils.Observer;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public interface Scheduler extends Observer {
    void setOS (OperatingSystem parentOS);
    void setProcessor(Processor systemProcessor);
    void push(Process process);
    boolean isEmpty();
}
