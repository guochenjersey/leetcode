package org.black.lotus.kata;

import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.
 * <p>
 * What is the most number of chunks we could have made?
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [4,3,2,1,0]
 * Output: 1
 * Explanation:
 * Splitting into two or more chunks will not return the required result.
 * For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
 * Example 2:
 * <p>
 * Input: arr = [1,0,2,3,4]
 * Output: 4
 * Explanation:
 * We can split into two chunks, such as [1, 0], [2, 3, 4].
 * However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
 * Note:
 * <p>
 * arr will have length in range [1, 10].
 * arr[i] will be a permutation of [0, 1, ..., arr.length - 1].
 */
@LeetCode
@Medium
@NoIdeaOrBadIdeaInitially
public class MaxChunksToMakeSorted {

    /**
     * We only need to consider whether the maxmium value in the previous range(include current position)
     * equals to the current index.
     * 由于题目规定了数组是数[0, N - 1]的排列，所以最终排好序后，数组下标为i的数一定是i，即arr[i] == i。那么在初始数组中，如果arr[i] != i，为了让arr[i]回到对应的下标上，我们必须将下标i和下标arr[i]放到同一个分组中。
     *
     * 具体地，例如[1, 2, 0, 3, 4]，从左往右遍历数组，分组数初始化res = 0：
     *
     * 第一步，下标0上的数是1，1要位于下标1的位置上， 所以当前分组包含的下标最大值应为1，而当前下标为0，所以当前无法分组，res = 0；
     * 第二步，下标1上的数是2，2要位于下标2的位置上，所以当前分组包含的下标最大值应为2，而当前下标为1，所以当前无法分组，res = 0；
     * 第三步，下标2上的数是0，0要位于下标0的位置上，所以当前分组包含的下标最大值仍应为2，当前下标也为2，说明此位置之前的数中不包含比2大的数，可以在当前位置分组，res = 1；
     * 第四步，下标3上的数是3，3已经位于下标3的位置上，所以当前分组包含的下标最大值应为3，当前下标也为3，说明此位置之前的数中不包含比3大的数，可以在当前位置分组，res = 2；
     * 第五步，下标4上的数是4，4已经位于下标4的位置上，所以当前分组包含的下标最大值应为4，当前下标也为4，说明此位置之前的数中不包含比4大的数，可以在当前位置分组，res = 3；
     *
     * */
    public int maxChunksToSorted(int[] arr) {
        int count = 0, max = 0;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            if (max == i) count++;
        }
        return count;
    }
}
