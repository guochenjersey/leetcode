package org.black.lotus.sort;

public class BubbleSort {

  public static void sort(int[] toSort) {
    if (toSort == null || toSort.length == 0) {
      return;
    }
    for (int i = 0; i < toSort.length; ++i) {
      for (int j = 0; j < toSort.length - i - 1; ++j) {
        if (toSort[j] > toSort[j + 1]) {
          int temp = toSort[j];
          toSort[j] = toSort[j + 1];
          toSort[j + 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] array = {4, 1, 9, 18, 12, 4};
    sort(array);
    for (int i : array) {
      System.out.println(i);
    }

    System.out.println(new Integer("234"));
  }
}
