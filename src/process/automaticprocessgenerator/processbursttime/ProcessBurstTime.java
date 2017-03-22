package process.automaticprocessgenerator.processbursttime;

import process.automaticprocessgenerator.processbursttrend.ProcessBurstTrend;

/**
 * Created by Karol on 2017-03-22.
 */
public enum ProcessBurstTime {
    SMALLER(2, "SMALL"),
    EQUAL(10, "EQUAL"),
    GREATER(100, "GREATER");

    private int value;
    private String name;

    ProcessBurstTime(int value, String name){
        this.value = value;
        this.name = name;
    }

    public String getName(){
        return this.name();
    }

    public int getValue(){
        return this.value;
    }
}
