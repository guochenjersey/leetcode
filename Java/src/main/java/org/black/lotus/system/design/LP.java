package org.black.lotus.system.design;

import org.apache.commons.lang3.RandomUtils;

import java.util.LinkedList;
import java.util.List;

public class LP {

    private String lpName;

    public LP(String lpName) {
        this.lpName = lpName;
    }

    /**
     * Produce price based on symbol and number per second
     * */
    public List<Double> produceTicket(Symbol symbol, int numPerSec) {
        List<Double> tickets = new LinkedList<>();
        for (int i = 0; i < numPerSec; ++i) {
            tickets.add(RandomUtils.nextDouble(1.0, 1.3));
        }

        return tickets;
    }
}
