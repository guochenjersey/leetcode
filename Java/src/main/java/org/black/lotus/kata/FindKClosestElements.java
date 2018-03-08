package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
