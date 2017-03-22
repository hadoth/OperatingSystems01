package scheduler;

import utils.Observer;

/**
 * Created by Karol Pokomeda on 2017-03-19.
 */
public interface Scheduler extends Observer {
    public void addProcess(Process newProcess);
}
