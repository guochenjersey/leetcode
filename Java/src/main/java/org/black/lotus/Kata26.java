package org.black.lotus;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * <pre>
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 </pre>
 * */
public class Kata26 {

    public static int removeDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int current = 0, next = 1; next < nums.length; ++next, ++current) {
            if (nums[current] != nums[next]) {
                ++size;
                nums[size] = nums[next];
            }
        }

        return size + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 2, 2, 2, 3};
        System.out.println(removeDuplicate(input));
        System.out.println(ToStringBuilder.reflectionToString(input));
    }
}
