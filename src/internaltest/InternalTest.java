package internaltest;

import process.Process;

/**
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class InternalTest {
    public static void main(String[] args) {
        Process newProcess = new Process("NOTEPAD", 35, 0);

        System.out.println(newProcess);

        do {
            System.out.println(newProcess.getRemainingTime());
        } while (newProcess.tick() > 0);

        System.out.println(newProcess);
    }
}
