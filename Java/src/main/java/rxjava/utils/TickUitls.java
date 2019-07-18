package rxjava.utils;

import org.apache.commons.lang3.RandomUtils;
import rxjava.model.Price;
import rxjava.model.Quantity;
import rxjava.model.Symbol;
import rxjava.model.Tick;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TickUitls {
    public static String[] currencyPairs = {"EUR/USD", "USD/JPY", "GBP/USD"};

    public static Tick createTick() {
        Symbol symbol = new Symbol(currencyPairs[RandomUtils.nextInt(0, 2)], LocalDate.MAX, LocalDate.MIN);
        Price price = new Price(new BigDecimal(RandomUtils.nextDouble(0, 2)));
        Quantity quantity = new Quantity(new BigDecimal(RandomUtils.nextInt(0, 1000)));
        return new Tick(String.valueOf(RandomUtils.nextInt(0, 100000)), price, symbol, quantity);
    }
}
