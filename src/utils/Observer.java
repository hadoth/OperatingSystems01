package utils;

import processor.ProcessEvent;

/**
 * Created by Karol Pokomeda on 2017-03-14.
 */
public interface Observer {
    void update(ProcessEvent event);
}
