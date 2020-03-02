package org.black.lotus.om.tick;


import org.black.lotus.om.side.PriceSide;
import org.black.lotus.om.symbol.Symbol;

public interface Tick {

    Symbol getSymbol();
    PriceSide getPriceSide();
    double getPrice();
}
