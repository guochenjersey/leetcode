package org.black.lotus.om.orderbook;

import org.black.lotus.om.order.LimitOrder;
import org.black.lotus.om.tick.Tick;

import java.util.List;

public interface LimitOrderBook<T extends LimitOrder> {

    void add(T order);

    boolean remove(T order);

    List<T> handle(List<Tick> ticks);

    int size();
}
