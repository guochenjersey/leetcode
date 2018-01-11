package org.black.lotus.misc.tax;

import javax.money.MonetaryAmount;

public class DefaultTaxContext {

  private MonetaryAmount grossIncome;

  public static DefaultTaxContext of(MonetaryAmount grossIncome) {
    DefaultTaxContext taxContext = new DefaultTaxContext();
    taxContext.grossIncome = grossIncome;
    return taxContext;
  }
}
