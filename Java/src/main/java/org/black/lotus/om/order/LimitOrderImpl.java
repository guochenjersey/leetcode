package org.black.lotus.om.order;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.black.lotus.om.date.SettlementDate;
import org.black.lotus.om.symbol.Symbol;

import java.util.UUID;

@RequiredArgsConstructor
@Data
public class LimitOrderImpl implements LimitOrder {

    private @NonNull Symbol symbol;
    private @NonNull double limitPrice;
    private @NonNull SettlementDate settlementDate;
    private @NonNull UUID id;
    private @NonNull OrderSide orderSide;
}
