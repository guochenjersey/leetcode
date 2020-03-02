package org.black.lotus.om.symbol;

import lombok.Data;

@Data
public class SymbolImpl implements Symbol {
    private Currency base;
    private Currency term;
}
