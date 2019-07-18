package rxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tick {
    private String tickId;
    private Price price;
    private Symbol symbol;
    private Quantity quantity;
}
