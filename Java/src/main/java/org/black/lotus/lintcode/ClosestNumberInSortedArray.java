package org.black.lotus.lintcode;

public class ClosestNumberInSortedArray {

  /*
   * @param A: an integer array sorted in ascending order
   * @param target: An integer
   * @return: an integer
   */
  public int closestNumber(int[] source, int target) {
    if (source == null || source.length == 0) {
      return -1;
    }
    if (target >= source[source.length - 1]) {
      return source.length - 1;
    } else if (target <= source[0]) {
      return 0;
    }
    int lowerBoundIndex = 0;
    int upperBoundIndex = source.length - 1;
    int previousLowerBoundIndex = -1;
    int previousUpperBoundIndex = -1;
    while ((lowerBoundIndex < upperBoundIndex)
        && (Math.abs(upperBoundIndex - lowerBoundIndex) > 1)) {
      previousLowerBoundIndex = lowerBoundIndex;
      previousUpperBoundIndex = upperBoundIndex;
      // careful about how to get the middle index here.
      int distance = (upperBoundIndex - lowerBoundIndex) / 2;
      int middle = distance + lowerBoundIndex;
      if (source[middle] == target) {
        return middle;
      } else if (target < source[middle] && target > source[lowerBoundIndex]) {
        upperBoundIndex = middle;
        previousUpperBoundIndex = middle;
      } else if (target > source[middle] && target < source[upperBoundIndex]) {
        lowerBoundIndex = middle;
        previousLowerBoundIndex = middle;
      }
    }

    if (Math.abs(target - source[previousLowerBoundIndex])
        < Math.abs(target - source[previousUpperBoundIndex])) {
      return previousLowerBoundIndex;
    } else {
      return previousUpperBoundIndex;
    }
  }

  public static void main(String... args) {
    int[] source = {1, 4, 6, 10, 20};
    int target = 21;
    ClosestNumberInSortedArray closestNumberInSortedArray = new ClosestNumberInSortedArray();
    int index = closestNumberInSortedArray.closestNumber(source, target);
    System.out.println(index);
  }
}
