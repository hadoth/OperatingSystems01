package scheduler;

import process.Process;
import utils.Observer;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public interface Scheduler extends Observer {
    public void addProcess(Process newProcess);

    void push(Process process);

    boolean isEmpty();
}
