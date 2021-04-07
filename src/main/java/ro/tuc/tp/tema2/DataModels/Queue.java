package ro.tuc.tp.tema2.DataModels;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;


public class Queue implements  Runnable{
    private BlockingQueue<Client> Clients;
    private AtomicInteger waitingTime;
    private int totalProgressingTime;
    private int totalClientsNumber;

    public Queue(){
        Clients = new LinkedBlockingQueue<>();
        waitingTime = new AtomicInteger();
        waitingTime.set(0);
        totalClientsNumber = 0;
        totalProgressingTime = 0;
    }


    public void addClient(Client c){
        Clients.add(c);
        totalClientsNumber++;
        if(Clients.peek()!=null)
            totalProgressingTime += Clients.peek().getProcessingTime();
        waitingTime.addAndGet(c.getProcessingTime());
    }

    @Override
    public void run(){
        while(true){
            Client c = Clients.peek();
            try {
                if(c!=null)
                    Thread.sleep(c.getProcessingTime() * 1000L);
                c = Clients.take();
                waitingTime.addAndGet(-c.getProcessingTime());
              //  System.out.println("Scad waitingTime  ");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public AtomicInteger getWaitingTime(){ return waitingTime; }

    public String toString(){
        if(!Clients.isEmpty())
            return Clients.toString();
        return "closed";
    }

    public Client getFirstClient(){
        return Clients.peek();
    }

    public void deleteFirstClient(){
        Clients.remove();
    }

    public Client[] getClients(){
        Client[] c = new Client[Clients.size()];
        int i = 0;
        for(Client a : Clients) {
            c[i] = a;
            i++;
        }
        return c;
    }

    public float getAverageWaitingTime(){
        if(totalClientsNumber!=0)
            return totalProgressingTime/(float)totalClientsNumber;
        return 0;
    }

}
