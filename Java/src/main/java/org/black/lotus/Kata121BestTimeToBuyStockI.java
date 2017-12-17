package org.black.lotus;

public class Kata121BestTimeToBuyStockI {

  public int maxProfit(int[] prices) {
    if (prices == null || prices.length == 0) {
      return 0;
    }

    int min = Integer.MAX_VALUE, max = 0, minIdx = -1, maxIdx = -1;
    for (int i = 0; i < prices.length; ++i) {
      if (prices[i] < min) {
        min = prices[i];
        minIdx = i;
      }

      if (prices[i] > max && i > minIdx) {
        max = prices[i];
        maxIdx = i;
      }
    }

    return max - min > 0 ? max - min : 0;
  }

  public static void main(String... args) {
    Kata121BestTimeToBuyStockI kata121BestTimeToBuyStockI = new Kata121BestTimeToBuyStockI();
    int i = kata121BestTimeToBuyStockI.maxProfit(new int[] {2, 4, 1});
    System.out.println(i);
  }
}
