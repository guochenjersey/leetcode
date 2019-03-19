package org.black.lotus.kata;

/**
 * Calculate the trailing zeros of an integer
 *
 * <p>hint: binary search
 *
 * <p>二分做法 假设有input int x和该int长度 每次x/10^(长度/2) x%10^(长度/2) 如果余数不为零 往右边二分 为零左边二分 以此类推
 */
public class IntegerWithTrailingZeros {

  public int trailingZeros(int n) {
    int res = 0;
    String str = String.valueOf(n);
    int start = 0;
    int end = str.length() - 1;
    while (start + 1 < end) {
      int mid = (end - start) / 2;
      int dividend = (int) Math.pow(10, mid);
      if (n % dividend == 0) {}
    }
    return res;
  }
}
