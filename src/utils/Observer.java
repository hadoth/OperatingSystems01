package utils;

import process.Process;

/**
 * Created by Karol Pokomeda on 2017-03-14.
 */
public interface Observer {
    void update(ProcessEvent event);
}
