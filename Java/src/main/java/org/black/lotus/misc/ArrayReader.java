package org.black.lotus.misc;

public class ArrayReader {

  public int get(int k) {
    int[] source = {1, 3, 6, 9, 21};
    if (k > source.length - 1) {
      return Integer.MAX_VALUE;
    }
    return source[k];
  }
}
