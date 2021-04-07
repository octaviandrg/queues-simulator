package ro.tuc.tp.tema2.DataModels;

import java.util.List;

public class
StrategyQueue implements Strategy{
    @Override
    public void addClient(List<Queue> queues, Client c) {
        Queue aux = queues.get(0);
        for(Queue q : queues)
            if(q.getClients().length < aux.getClients().length) {
                aux = q;
            }
        aux.addClient(c);
    }

}
