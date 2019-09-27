package org.black.lotus.om.order;

import org.black.lotus.om.date.SettlementDate;
import org.black.lotus.om.symbol.Symbol;

public interface MarketOrder extends Order {
    Symbol getSymbol();
    SettlementDate getSettlementDate();
}
