package org.black.lotus.om.symbol;

public interface FxSymbol extends Symbol {
    Currency baseCurrency();
    Currency termCurrency();
}
