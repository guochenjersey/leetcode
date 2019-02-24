package org.black.lotus.kata;

import org.black.lotus.marker.*;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example 1:

 Input: 2
 Output: [0,1,1]
 Example 2:

 Input: 5
 Output: [0,1,1,2,1,2]
 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 *
 * 0    0000    0
 -------------
 1    0001    1
 -------------
 2    0010    1
 3    0011    2
 -------------
 4    0100    1
 5    0101    2
 6    0110    2
 7    0111    3
 -------------
 8    1000    1
 9    1001    2
 10   1010    2
 11   1011    3
 12   1100    2
 13   1101    3
 14   1110    3
 15   1111    4
 *
 * 我最先看出的规律是这样的，除去前两个数字0个1，从2开始，2和3，是[21, 22)区间的，值为1和2。而4到7属于[22, 23)区间的，值为1,2,2,3，前半部分1和2和上一区间相同，2和3是上面的基础上每个数字加1。再看8到15，属于[23, 24)区间的，同样满足上述规律，所以可以写出代码如下：
 * */
@LeetCode
@FirstRound
@Medium
@NoIdeaOrBadIdeaInitially
public class CountingBits {

    public int[] countBits(int num) {
        return bruteForce(num);
    }

    @TLESolution
    private int[] bruteForce(int num) {
        int[] res = new int[num + 1];
        for (int i = 0; i <= num; ++i) {
            String s = Integer.toBinaryString(i);
            char[] chars = s.toCharArray();
            int j = 0;
            for (char c : chars) {
                if (c == '1')
                    ++j;
            }
            res[i] = j;
        }

        return res;
    }
}
