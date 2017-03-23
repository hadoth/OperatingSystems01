package os;

import process.Process;
import utils.Observer;

/**
 * Created by Karol on 2017-03-19.
 */
public interface OperatingSystem extends Observer {
    void run();
    void push(Process process);
    void generateReport(String path);
}
