package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

 Example 1:
 Input: [1,2,3,4,5], k=4, x=3
 Output: [1,2,3,4]
 Example 2:
 Input: [1,2,3,4,5], k=4, x=-1
 Output: [1,2,3,4]
 Note:
 The value k is positive and will always be smaller than the length of the sorted array.
 Length of the given array is positive and will not exceed 104
 Absolute value of elements in the array and x will not exceed 104
 *
 * 注意 最接近的那个数字必须满足以下条件中的一个
 * 1) 和MIDDLE相等.
 * 2) < MIDDLE && > middle - 1
 * 3) > middle && < middle + 1
 *
 * */
@FirstRound
@LeetCode
@NoIdeaOrBadIdeaInitially
@Important
public class FindKClosestElements {

    public List<Integer> findClosestElements(int[] nums, int kElements, int target) {
        List<Integer> res = new ArrayList<>();
        if (target <= nums[0]) {
            for (int i = 0; i < kElements; i ++) {
                res.add(nums[i]);
            }
            return res;
        } else if (target >= nums[nums.length - 1]) {
            for (int i = nums.length - kElements; i < nums.length; ++i) {
                res.add(nums[i]);
            }
            return res;
        }


        int start = 0;
        int end = nums.length - 1;
        int minDiffIndex = -1;
        while (start + 1 < end) {
            int middle = start + (end - start) / 2;
            if (nums[middle] == target) {
                minDiffIndex = middle;
                end = middle;
            } else if (nums[middle] < target && target < nums[middle + 1]) {
                minDiffIndex = ((target - nums[middle]) > (nums[middle + 1] - target)) ? middle + 1 : middle;
                break;
            } else if (nums[middle] > target && nums[middle - 1] < target) {
                minDiffIndex = ((nums[middle] - target) > (target - nums[middle-1])) ? middle -1 : middle;
                break;
            } else if (nums[middle] > target) {
                end = middle;
            } else {
                start = middle;
            }
        }

        if (nums[end] == target) {
            minDiffIndex = end;
        }

        if (nums[start] == target) {
            minDiffIndex = start;
        }

        if (minDiffIndex == -1) {
            minDiffIndex = ((target - nums[start]) > (nums[end] - target)) ? end : start;
        }

        LinkedList<Integer> results = new LinkedList<>();

        int i = minDiffIndex;
        int j = minDiffIndex - 1;
        while (results.size() < kElements) {
                if (isInbound(j, nums)) {
                    if (isInbound(i, nums)) {
                        int iDis = Math.abs(nums[i] - target);
                        int jDis = Math.abs(nums[j] - target);
                        if (iDis < jDis ) {
                            results.addLast(nums[i]);
                            ++i;
                        } else {
                            results.addFirst(nums[j]);
                            --j;
                        }
                    } else {
                        results.addFirst(nums[j]);
                        --j;
                    }
                } else {
                    results.addLast(nums[i]);
                    ++i;
                }

        }

        return results;
    }

    private boolean isInbound(int i, int[] source) {
        return i >=0 && i < source.length;
    }
}
