package org.black.lotus.kata;

import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.NotAccepted;

import java.util.ArrayList;
import java.util.List;

@LeetCode
@FirstRound
@NotAccepted
/**
 * Correctness seems no problem, but not efficiency enough.
 * */
public class TargetSum {

    private static final String[] SYMBOLS = {"-", "+"};

    public int findTargetSumWays(int[] nums, int target) {
        List<List<String>> signs = new ArrayList<>();
        List<String> path = new ArrayList<>();

        dfs(signs, path, nums);

        int res = 0;
        for (List<String> sign : signs) {
            if (isSumEqualsToTarget(sign, nums, target)) {
                ++res;
            }
        }

        return res;
    }

    private boolean isSumEqualsToTarget(List<String> signs, int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += signs.get(i).equals("-") ? Math.negateExact(nums[i]) : nums[i];
        }

        return sum == target;

    }

    private void dfs(List<List<String>> signs, List<String> sign, int[] nums) {
        if (sign.size() == nums.length) {
            signs.add(new ArrayList<>(sign));
            return;
        }

        for (String s : SYMBOLS) {
            sign.add(s);
            dfs(signs, sign, nums);
            sign.remove(sign.size() - 1);
        }
    }

    public static void main(String... args) {
        int[] nums = {42,24,30,14,38,27,12,29,43,42,5,18,0,1,12,44,45,50,21,47};
        TargetSum targetSum = new TargetSum();
        int targetSumWays = targetSum.findTargetSumWays(nums, 38);
        System.out.println(targetSumWays);
    }
}
