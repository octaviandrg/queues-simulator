package ro.tuc.tp.tema2.DataModels;

import java.util.List;

public class StrategyTime implements Strategy{
    @Override
    public void addClient(List<Queue> queues, Client c) {
        Queue aux = queues.get(0);
        for(Queue q: queues){
            if(q.getWaitingTime().intValue() < aux.getWaitingTime().intValue()){
                aux = q;
            }
        }
        aux.addClient(c);
    }
}
