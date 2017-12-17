package org.black.lotus;

import java.util.List;

/** Beautiful arrangement */
public class Kata526 {

  public int countArrangement(int n) {
    int res = 0;

    return res;
  }

  public boolean solve(int i, List<Integer> curr) {
    curr.add(i);
    for (int j = 0; j < curr.size(); ++j) {
      if (curr.get(j) % (j + 1) != 0) {
        return false;
      }
    }

    return true;
  }
}
