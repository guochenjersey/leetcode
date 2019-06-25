package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 * <p>
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
@LeetCode
@Easy
@Accepted("13.9%")
@FirstRound
public class DuplicateZeros {

    // fast solution 95%
    public void fastDuplicateZeros(int[] arr) {
        // count number of zeros
        int zeroCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                zeroCount++;
        }

        // iterate backwards, shift numbers until no more zero can be found on the left side
        for (int curIndex = arr.length - 1; zeroCount > 0 && curIndex >= 0 ; curIndex--) {
            int shiftIndex = curIndex + zeroCount;
            // shift number within the array boundary
            if (shiftIndex < arr.length)
                arr[shiftIndex] = arr[curIndex];

            if (arr[curIndex] == 0) {
                int duplicateZeroIndex = shiftIndex - 1;
                if (duplicateZeroIndex < arr.length)
                    arr[duplicateZeroIndex] = 0;
                zeroCount--;
            }
        }
    }

    // slow solution
    public void duplicateZeros(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int i = 0; i < arr.length;) {
            if (arr[i] == 0 && (i + 1) < arr.length) {
                int tmp = arr[i + 1];
                arr[i + 1] = 0;
                for (int j = i + 2; j < arr.length; ++j) {
                    int k = arr[j];
                    arr[j] = tmp;
                    tmp = k;
                }
                i += 2;
            } else {
                ++i;
            }
        }
    }
}
