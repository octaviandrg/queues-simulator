package ro.tuc.tp.tema2.DataModels;



public class Client implements Comparable<Client>{
    private int id;
    private Integer arrivalTime;
    private int processingTime;
    private int finishTime;

    public Client(int id, int arrivalTime, int processingTime){
        this.id = id;
        this.arrivalTime = arrivalTime;
        this.processingTime = processingTime;
        this.finishTime = this.arrivalTime + this.processingTime;
    }

    public int getArrivalTime(){
        return arrivalTime;
    }

    public int getID(){
        return id;
    }

    public int getFinishTime(){ return finishTime; }

    public int getProcessingTime(){ return processingTime; }

    public void setProcessingTime(int  processingTime){ this.processingTime = processingTime; }

    public String toString(){
        return "(" + getID() + "," + getArrivalTime() + "," + getProcessingTime() + ") ";
    }

    @Override
    public int compareTo(Client c) {
            return this.arrivalTime.compareTo(c.arrivalTime);

        }
    }

