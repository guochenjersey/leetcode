package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

/**
 * Reverse bits of a given 32 bits unsigned integer.



 Example 1:

 Input: 00000010100101000001111010011100
 Output: 00111001011110000010100101000000
 Explanation: The input binary string 00000010100101000001111010011100 represents the unsigned integer 43261596, so return 964176192 which its binary representation is 00111001011110000010100101000000.
 Example 2:

 Input: 11111111111111111111111111111101
 Output: 10111111111111111111111111111111
 Explanation: The input binary string 11111111111111111111111111111101 represents the unsigned integer 4294967293, so return 3221225471 which its binary representation is 10101111110010110010011101101001.


 Note:

 Note that in some languages such as Java, there is no unsigned integer type. In this case, both input and output will be given as signed integer type and should not affect your implementation, as the internal binary representation of the integer is the same whether it is signed or unsigned.
 In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 2 above the input represents the signed integer -3 and the output represents the signed integer -1073741825.


 Follow up:

 If this function is called many times, how would you optimize it?
 * */
@LeetCode
@Easy
@FirstRound
@NoIdeaOrBadIdeaInitially
public class ReverseBits {

    public int reverseBits(int n) {
        for (int i = 0; i < 16; ++i) {
            n = swapBits(n, i, 32 - i - 1);
        }

        return n;
    }

    private int swapBits(int n, int i, int j) {
        int a = (n >> i) & 1;
        int b = (n >> j) & 1;

        if ((a ^ b) != 0) {
            return (n ^= (1 << i) | (1 << j)); // important 的数位取反技巧
        }
        return n;
    }
}
