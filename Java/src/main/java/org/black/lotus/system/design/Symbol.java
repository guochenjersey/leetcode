package org.black.lotus.system.design;

import lombok.Data;

@Data
public class Symbol {
    private String currencyPair;

    public Symbol(String currencyPair) {
        this.currencyPair = currencyPair;
    }
}
