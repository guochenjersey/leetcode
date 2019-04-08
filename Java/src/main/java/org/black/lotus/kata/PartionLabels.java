package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.Medium;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.*;

/**
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

 Example 1:
 Input: S = "ababcbacadefegdehijhklij"
 Output: [9,7,8]
 Explanation:
 The partition is "ababcbaca", "defegde", "hijhklij".
 This is a partition so that each letter appears in at most one part.
 A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 Note:

 S will have length in range [1, 500].
 S will consist of lowercase letters ('a' to 'z') only.


 这道题给了我们一个字符串S，然我们将其尽可能多的分割为子字符串，条件是每种字符最多只能出现在一个子串中。比如题目汇总的例子，字符串S中有多个a，这些a必须只能在第一个子串中，再比如所有的字母e值出现在了第二个子串中。那么这道题的难点就是如何找到字符串的断点，即拆分成为子串的位置。我们仔细观察题目中的例子，可以发现一旦某个字母多次出现了，那么其最后一个出现位置必须要在当前子串中，字母a，e，和j，分别是三个子串中的结束字母。所以我们关注的是每个字母最后的出现位置，我们可以使用一个HashMap来建立字母和其最后出现位置之间的映射，那么对于题目中的例子来说，我们可以得到如下映射：

 a -> 8
 b -> 5
 c -> 7
 d -> 14
 e -> 15
 f -> 11
 g -> 13
 h -> 19
 i -> 22
 j -> 23
 k -> 20
 l -> 21

 建立好映射之后，就需要开始遍历字符串S了，我们维护一个start变量，是当前子串的起始位置，还有一个last变量，是当前子串的结束位置，每当我们遍历到一个字母，我们需要在HashMap中提取出其最后一个位置，因为一旦当前子串包含了一个字母，其必须包含所有的相同字母，所以我们要不停的用当前字母的最后一个位置来更新last变量，只有当i和last相同了，即当i = 8时，当前子串包含了所有已出现过的字母的最后一个位置，即之后的字符串里不会有之前出现过的字母了，此时就应该是断开的位置，我们将长度9加入结果res中，同理类推，我们可以找出之后的断开的位置，参见代码如下：

 * */
@LeetCode
@Medium
@Accepted
@NoIdeaOrBadIdeaInitially
public class PartionLabels {

    public List<Integer> partitionLabels(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }

        if (s.length() == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(1);
            return res;
        }

        Map<Character, Integer> charOccuranceMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            charOccuranceMap.put(chars[i], i);
        }

        List<Integer> res = new ArrayList<>();
        int currentEnd = charOccuranceMap.get(chars[0]);
        for (int i = 0; i < chars.length; ++i) {
            currentEnd = Math.max(currentEnd, charOccuranceMap.get(chars[i]));
            if (i == currentEnd) {
                if (res.size() == 0) {
                    res.add(i + 1);
                } else {
                    int sum = res.stream().mapToInt(j -> j).sum();
                    res.add(i - sum + 1);
                }
            }
        }

        return res;
    }
}
