package ro.tuc.tp.tema2.Logic;

import ro.tuc.tp.tema2.DataModels.Client;
import ro.tuc.tp.tema2.DataModels.Queue;
import ro.tuc.tp.tema2.DataModels.Scheduler;
import ro.tuc.tp.tema2.DataModels.SelectionPolicy;
import ro.tuc.tp.tema2.GUI.SimulationFrame;

import java.util.*;

public class SimulationManager implements Runnable{
    // data read from UI
    public static int timeLimit;
    public static int maxProcessingTime ;
    public static int minProcessingTime ;
    public static int maxArrivalTime ;
    public static int minArrivalTime ;
    public static int numberOfQueues ;
    public static int numberOfClients ;
    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;

    private Scheduler scheduler;
    private SimulationFrame frame;
    private List<Client> generatedClients;

    public SimulationManager(){
        frame = new SimulationFrame();
        while(!frame.isStart());
        scheduler = new Scheduler(numberOfQueues,numberOfClients);
        scheduler.changeStrategy(selectionPolicy);
        generatedClients = new ArrayList<>();
        Thread[] th = new Thread[numberOfQueues];
        List<ro.tuc.tp.tema2.DataModels.Queue> Queues = new ArrayList<>();
        for(int i=0; i<numberOfQueues; i++){
            ro.tuc.tp.tema2.DataModels.Queue nq = new Queue();
            Queues.add(nq);
            th[i] = new Thread((Queues.get(i)));
            th[i].start();
        }
        generatedClients = generateNRandomClients();
    }

    private List<Client> generateNRandomClients(){
        Random random = new Random();
        List<Client> generatedClientsAux = new ArrayList<Client>();
        for(int i=1; i<=numberOfClients; i++) {
            int processingTime = random.nextInt((maxProcessingTime - minProcessingTime) + 1) + minProcessingTime;
            int arrivalTime = random.nextInt((maxArrivalTime - minArrivalTime) + 1) + minArrivalTime;
            generatedClientsAux.add(new Client(i,arrivalTime, processingTime));
        }
        Collections.sort(generatedClientsAux);
        return generatedClientsAux;
    }


    @Override
    public void run() {
        String output;
        int currentTime = 0;
        int timpMin = 9999;
        while(currentTime < timeLimit){
            output = "Time " + currentTime + "\nWaiting clients: ";

            for(Iterator<Client> iterator = generatedClients.iterator(); iterator.hasNext(); ){
                Client c = iterator.next();
                if(c.getArrivalTime() == currentTime){
                    scheduler.dispatchClient(c);
                    iterator.remove();
                }else if(c.getArrivalTime() > currentTime) {
                    output += "" + c.toString();
                    if(c.getArrivalTime() < timpMin)
                        timpMin = c.getArrivalTime();
                }
            }
            output += "\n";
            for(int i=0; i < scheduler.getQueues().size(); i++){
                output += "Queue "+ i + ": ";
                if( currentTime < timpMin || scheduler.getQueues().isEmpty())
                    output += "closed\n";
                else{
                    if(scheduler.getQueues().get(i).getFirstClient()!=null) {
                        scheduler.getQueues().get(i).getFirstClient().setProcessingTime(scheduler.getQueues().get(i).getFirstClient().getProcessingTime() - 1); //aici descrementez processingtime primului client cu 1
                        if (scheduler.getQueues().get(i).getFirstClient().getProcessingTime() == 0)
                            scheduler.getQueues().get(i).deleteFirstClient();
                    }
                    output += scheduler.getQueues().get(i).toString()+ "\n";
                }}

            /*try {
                frame.doc.insertString(frame.doc.getLength(),output,null);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }*/
            System.out.println(output);
            frame.textOutput.setText(output+"\n");
            frame.textCurrentTime.setText(String.valueOf(currentTime));
            boolean stopSim = false;
            for(int i=0; i < scheduler.getQueues().size(); i++) {

                if (generatedClients.size() == 0 && scheduler.getQueues().get(i).getFirstClient() == null) {
                     stopSim = true;
                } else{
                    stopSim = false;
                    break;
            }}
            float media_totala = 0;
            if(stopSim) {
                for(int i=0; i < scheduler.getQueues().size(); i++)
                    media_totala += scheduler.getQueues().get(i).getAverageWaitingTime();
                System.out.println("Average waiting time is: " + media_totala/(float)scheduler.getQueues().size());
                System.exit(0);
            }
            currentTime++;
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        float media_totala = 0;
        for(int i=0; i < scheduler.getQueues().size(); i++)
            media_totala += scheduler.getQueues().get(i).getAverageWaitingTime();
        System.out.println("Average waiting time is: " + media_totala/(float)scheduler.getQueues().size());
        System.exit(0);
    }

    public static void main(String[] args){
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();

    }
}
