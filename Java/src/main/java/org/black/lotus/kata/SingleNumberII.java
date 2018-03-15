package org.black.lotus.kata;

import org.black.lotus.marker.*;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 　Given an array of integers, every element appears three times except for one. Find that single one.
 　　Note:
 　　Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * */
@FirstRound
@LintCode
@NoIdeaOrBadIdeaInitially
@NotAccepted
@Important
@Medium
public class SingleNumberII {

    public int singleNumberII(int[] nums) {
        int[] count = new int[32];
        int result = 0;
        for (int i = 0; i < 32; ++i) {
            for (int n : nums) {
                if ((( n >> i) & 1) == 1) {
                    count[i]++;
                }
            }
            // 从01数组到二进制数转换.
            result |= (count[i] % 3) << i;
        }
        return result;
    }

    public static void main(String... args) {
        int num = -1;
        // 右移动操作可以保证符号位,所以可以用来做数字到字符串的转换
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 32; ++i) {
            int k = num >> i & 1;
            res.insert(0, k);
        }
        System.out.println(res);
    }
}