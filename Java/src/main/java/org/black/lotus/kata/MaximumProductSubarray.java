package org.black.lotus.kata;

import java.math.BigInteger;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/** TODO */
@LeetCode
@Medium
@FirstRound
@NoIdeaOrBadIdeaInitially
public class MaximumProductSubarray {

  public int maxProduct(int[] nums) {
    BigInteger product = BigInteger.ONE;
    BigInteger maxProd = null;
    for (int i : nums) {
      BigInteger iVal = new BigInteger(String.valueOf(i));
      product = product.multiply(iVal);
      if (iVal.compareTo(product) > 0) {
        product = iVal;
      }
      if (maxProd == null) {
        maxProd = product;
      }
      if (maxProd.compareTo(product) < 0) {
        maxProd = product;
      }
    }

    return maxProd.intValue();
  }
}
