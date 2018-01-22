package org.black.lotus.lintcode;

/**
 * MERGE SORT的特点如下
 * 1) 它是先局部有序,再全局有序.
 * 2) 它是稳定排序.
 * 3) 它需要一个O(M+N)的空间.
 * */
public class MergeSortSolution {

  public void sortArray(int[] source) {
    if (source == null || source.length == 0) {
      return;
    }
    int start = 0;
    int end = source.length - 1;
    int[] temp = new int[source.length];
    mergeSort(source, start, end, temp);
  }

  private void mergeSort(int[] source, int start, int end, int[] temp) {
    if (start >= end) {
      return;
    }

    // 注意merge sort的特点,它是局部有序,再全局有序.
    mergeSort(source, start, (start + end) / 2, temp);
    mergeSort(source, (start + end) / 2 + 1, end, temp);
    merge(source, start, end, temp);
  }

  private void merge(int[] source, int start, int end, int[] temp) {
    int middle = (start + end) / 2;
    int leftIndex = start;
    int rightIndex = middle + 1;
    int index = leftIndex;

    while (leftIndex <= middle && rightIndex <= end) {
      if (source[leftIndex] < source[rightIndex]) {
        temp[index++] = source[leftIndex++];
      } else {
        temp[index++] = source[rightIndex++];
      }
    }

    while (leftIndex <= middle) {
      temp[index++] = source[leftIndex++];
    }

    while (rightIndex <= end) {
      temp[index++] = source[rightIndex++];
    }

    for (int i = start; i <= end; ++i) {
      source[i] = temp[i];
    }
  }

  public static void main(String... args) {
    int[] sourceArray = {4, 5, 6, 8, 1, 2, 0, 5, 10, 3};
    MergeSortSolution mergeSortSolution = new MergeSortSolution();
    mergeSortSolution.sortArray(sourceArray);
    for (int aSourceArray : sourceArray) {
      System.out.println(aSourceArray);
    }
  }

}
