package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@LintCode
@FirstRound
@NoIdeaOrBadIdeaInitially
@Important
public class SingleNumberIII {

    public List<Integer> singleNumberIII(int[] nums) {
        int resTwo = 0;
        int[] res = new int[2];
        for (int i = 0; i < nums.length; ++i) {
            resTwo ^= nums[i];
        }

        int mask = 1;
        // find the rightest bit which is not 0
        // or resTwo ^= -resTwo
        for (int i = 0; i < 32; ++i) {
            if ((resTwo >> i & 1) == 1) {
                mask <<= i;
                break;
            }
        }

        for (int num : nums) {
            if ((num & mask) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }

        return Arrays.stream(res).boxed().collect(Collectors.toList());
    }

    public static void main(String... args) {
        int mask = 1, resTwo = 9;
        // find the rightest bit which is not 0
        for (int i = 0; i < 32; ++i) {
            if ((resTwo >> i & 1) == 1) {
                mask <<= i;
                break;
            }
        }

        System.out.println(mask);
    }
}
