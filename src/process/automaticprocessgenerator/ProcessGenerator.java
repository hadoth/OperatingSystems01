package process.automaticprocessgenerator;

import process.automaticprocessgenerator.arrivaltimefrequency.ArrivalTimeFrequency;
import process.automaticprocessgenerator.bursttimeaccuracy.BurstTimeAccuracy;
import process.automaticprocessgenerator.processbursttime.ProcessBurstTime;
import process.automaticprocessgenerator.processbursttrend.ProcessBurstTrend;
import process.Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

/**
 * Created by Karol on 2017-03-22.
 */
public class ProcessGenerator {
    private int processCount;
    private ProcessBurstTime burstTimeSize;
    private ProcessBurstTrend burstTimeTrend;
    private ArrivalTimeFrequency arrivalTimeFrequency;
    private BurstTimeAccuracy burstTimeAccuracy;

    private int[] burstTime;
    private int[] burstTimeEst;
    private int[] arrivalTime;
    private Process[] processList;

    private ProcessGenerator(){
    }

    public static ProcessGenerator makeProcessSeries(){
        return new ProcessGenerator();
    }

    public ProcessGenerator withProcessCount(int processCount){
        this.processCount = processCount;
        return this;
    }

    public ProcessGenerator withProcessBurstTime(ProcessBurstTime processBurstTime){
        this.burstTimeSize = processBurstTime;
        return this;
    }

    public ProcessGenerator withBurstTimeTrend(ProcessBurstTrend burstTimeTrend){
        this.burstTimeTrend = burstTimeTrend;
        return this;
    }

    public ProcessGenerator withArrivalTimeFrequency(ArrivalTimeFrequency arrivalTimeFrequency){
        this.arrivalTimeFrequency = arrivalTimeFrequency;
        return this;
    }

    public ProcessGenerator withBurstTimeAccuracy(BurstTimeAccuracy burstTimeAccuracy){
        this.burstTimeAccuracy = burstTimeAccuracy;
        return this;
    }

    public void buildAndSave(){
        this.makeProcessList();
        this.saveProcessList();
    }

    private void makeProcessList(){
        this.burstTime = this.burstTimeTrend.generateBurstTime(this.processCount, this.burstTimeSize);
        this.burstTimeEst = this.burstTimeAccuracy.generateBurstTimeEst(this.burstTime);
        this.arrivalTime = this.arrivalTimeFrequency.generateArrivalTime(this.processCount);
        this.processList = new Process[this.processCount];

        for (int i = 0; i < this.processCount; i++){
            this.processList[i] = new Process(UUID.randomUUID(), this.arrivalTime[i], this.burstTime[i], this.burstTimeEst[i]);
        }
    }

    private boolean saveProcessList(){
        boolean result = true;
        String filePath =
                this.burstTimeSize.getName() + "_" +
                        this.burstTimeTrend.getName() + "_" +
                        this.arrivalTimeFrequency.getName() + "_" +
                        this.burstTimeAccuracy.getName() + ".csv";
        File myFile = new File(filePath);
        try (
            FileWriter fileOut = new FileWriter(myFile);
            PrintWriter dataOut = new PrintWriter(fileOut);
        ){
            myFile.createNewFile();

            for (int i = 0; i < this.processCount; i++) dataOut.println(this.processList[i].toString());

            if (fileOut != null) fileOut.close();
            if (dataOut != null) dataOut.close();
        } catch (IOException e){
            result = false;
        }
        return result;
    }
}
