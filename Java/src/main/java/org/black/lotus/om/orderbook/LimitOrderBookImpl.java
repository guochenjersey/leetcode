package org.black.lotus.om.orderbook;

import org.black.lotus.om.order.LimitOrder;
import org.black.lotus.om.tick.Tick;

import java.util.ArrayList;
import java.util.List;

public class LimitOrderBookImpl<T extends LimitOrder> implements LimitOrderBook<T> {

    private List<T> limitOrders;

    public LimitOrderBookImpl() {
        limitOrders = new ArrayList<>();
    }

    @Override
    public void add(T order) {
        limitOrders.add(order);
    }

    @Override
    public boolean remove(T order) {
        return limitOrders.remove(order);
    }

    @Override
    public List<T> handle(List<Tick> ticks) {
        return null;
    }

    @Override
    public int size() {
        return limitOrders.size();
    }
}
