package os;

import process.ProcessImpl;
import utils.Observer;

/**
 * Created by Karol on 2017-03-19.
 */
public interface OperatingSystem extends Observer {
    void run();
    void push(ProcessImpl process);
    void generateReport(String path);
}
