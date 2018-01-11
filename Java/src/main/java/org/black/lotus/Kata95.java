package org.black.lotus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.money.CurrencyUnit;
import javax.money.convert.ExchangeRate;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;

public class Kata95 {

  public static void main(String... args) {
    List<String> myString = Arrays.asList("abc", "def");
    String joinedString = String.join(",", myString);
    System.out.println(joinedString);
  }
}

