package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/**
 * Write a function that add two numbers A and B. You should not use + or any arithmetic operators.
 *
 * <p>Notice There is no need to read data from standard input stream. Both parameters are given in
 * function aplusb, you job is to calculate the sum and return it.
 *
 * <p>Have you met this question in a real interview? Clarification Are a and b both 32-bit
 * integers?
 *
 * <p>Yes. Can I use bit operation?
 *
 * <p>Sure you can. Example Given a=1 and b=2 return 3
 *
 * <p>Challenge Of course you can just return a + b to get accepted. But Can you challenge not do it
 * like that?
 *
 * <p>Tags Related Problems
 *
 * <p>我们一直在想，求两个数之和四则运算都不能用，还能用什么？对数字做运算，除了四则运算之外，也就只剩下位运算了。位运算是针对二进制的，我们就以二进制再来分析一下前面的三步走的策略对二进制是不是也适用。
 *
 * <p>5的二进制是101，17的二进制是10001，还是试着把计算分成三步：第一步各位相加但不计进位，得到的结果是10100；第二步记下进位。在这个例子中只在最后一位相加时产生进位，结果是二进制的10，第三步把前两步的结果相加，得到的结果是10110，转换成十进制刚好是22，由此可见三步走的策略对二进制也是适用的。
 *
 * <p>接下来我们试着把二进制的加法用位运算来替换。第一步不考虑进位对每一位相加。0+0，1+1的结果都是0，1+0的结果是1。0+1的结果是1，我们注意到这和异或的结果是一样的。对异或而言，0和0，1和1异或的结果是0，而0和1，1和0的异或结果是1，接着考虑第二步进位，对0+0，0+1，1+0而言，都不会产生进位，只有1+1时，会向前差生一个进位。此时我们可以想象成是两个数先做位与运算，然后再向前左移动一位。只有两个数都是1的时候，位与得到的结果是1，其余都是0。第三步相加的过程是重复前面的两步，直到不产生进位为止。
 */
@LintCode
@FirstRound
public class APlusBProblem {

  public int aplusb(int num1, int num2) {
    // write your code here

    int sum, carry;
    do {
      sum = num1 ^ num2;
      carry = (num1 & num2) << 1;
      num1 = sum;
      num2 = carry;
    } while (num2 != 0);
    return num1;
  }
}
