package rxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Symbol {

    private String currencyPair;
    private LocalDate nearDate;
    private LocalDate farDate;
}
