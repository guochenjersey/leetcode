package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

 Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

 You may return any answer array that satisfies this condition.



 Example 1:

 Input: [4,2,5,7]
 Output: [4,5,2,7]
 Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.


 Note:

 2 <= A.length <= 20000
 A.length % 2 == 0
 0 <= A[i] <= 1000
 * */
@LeetCode
@Easy
@Accepted
public class SortArrayByParityII {

    public int[] sortArrayByParityII(int[] A) {
        if (A == null) {
            return null;
        }
        int[] res = new int[A.length];
        int j = 0;
        int k = 1;
        for (int i : A) {
            if (i % 2 == 0) {
                res[j] = i;
                j += 2;
            } else {
                res[k] = i;
                k += 2;
            }
        }

        return res;
    }
}
