package ro.tuc.tp.tema2.DataModels;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Queue> Queues;
    private int maxNoQueues;
    private int maxClientsPerQueue;
    private Strategy strategy;
  // private Thread[] th;

    public Scheduler(int maxNoQueues, int maxClientsPerQueue){
        Queues = new ArrayList<>();
        for(int i=0; i<maxNoQueues; i++){
            Queues.add(new Queue());
            new Thread((Queues.get(i)));
        }
    }

    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE)
            strategy = new StrategyQueue();
        if(policy == SelectionPolicy.SHORTEST_TIME)
            strategy = new StrategyTime();
    }

    public void dispatchClient(Client c){
        strategy.addClient(Queues, c);
    }

    public List<Queue> getQueues(){return Queues;}


}
