package rxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class Quantity {
    private BigDecimal quantity;
}
