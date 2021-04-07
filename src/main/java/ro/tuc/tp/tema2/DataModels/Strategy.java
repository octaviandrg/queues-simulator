package ro.tuc.tp.tema2.DataModels;

import java.util.List;

public interface Strategy {
    void addClient(List<Queue> queues, Client c);

}

