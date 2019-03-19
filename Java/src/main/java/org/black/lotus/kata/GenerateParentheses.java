package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.*;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed
 * parentheses.
 *
 * <p>For example, given n = 3, a solution set is:
 *
 * <p>[ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 *
 * <p>TODO
 */
@LeetCode
@Medium
@FirstRound
@Important
@Accepted
public class GenerateParentheses {

  public List<String> generateParenthesis(int n) {
    List<String> results = new ArrayList<>();
    if (n == 0) {
      return results;
    }
    String res = "";
    helper(results, n, res, 0, 0);
    return results;
  }

  private void helper(
      List<String> results, int n, String res, int leftUsedParentheses, int leftOpenParentheses) {
    if (n - leftUsedParentheses == 0) {
      StringBuilder sb = new StringBuilder(res);
      for (int i = 0; i < leftOpenParentheses; ++i) {
        sb.append(")");
      }
      results.add(sb.toString());
      return;
    }

    helper(results, n, res + "(", leftUsedParentheses + 1, leftOpenParentheses + 1);

    if (leftOpenParentheses > 0) {
      helper(results, n, res + ")", leftUsedParentheses, leftOpenParentheses - 1);
    }
  }
}
