package process;

/**
 * Class stores basic process characteristics for CPU scheduling simulation
 * Created by Karol Pokomeda on 2017-03-14.
 */
public class Process {

    private static int idBase = 1;
    private int processID;
    private String name;
    private int burstTime;
    private int arrivalTime;
    private int remainingTime;

    public Process(String name, int burstTime, int arrivalTime){
        this.processID = idGenerator();
        this.name = name;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.arrivalTime = arrivalTime;
    }

    public int tick(){
        return --this.remainingTime;
    }

    public int getBurstTime(){
        return this.burstTime;
    }

    public int getRemainingTime(){
        return this.remainingTime;
    }

    public int getArrivalTime(){
        return this.arrivalTime;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.processID + ",\t" + this.name + ",\t" + this.burstTime + ",\t" + this.arrivalTime + ",\n";
    }

    private static int idGenerator(){
        return idBase++;
    }
}