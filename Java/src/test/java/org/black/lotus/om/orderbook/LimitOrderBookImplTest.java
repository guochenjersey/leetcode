package org.black.lotus.om.orderbook;

import org.black.lotus.om.date.SettlementDateImpl;
import org.black.lotus.om.order.LimitOrder;
import org.black.lotus.om.order.LimitOrderImpl;
import org.black.lotus.om.symbol.SymbolImpl;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class LimitOrderBookImplTest {

    @Test
    public void should_be_able_to_add_order() {
        LimitOrderBookImpl<LimitOrder> limitOrderLimitOrderBook = new LimitOrderBookImpl<>();

    }
}