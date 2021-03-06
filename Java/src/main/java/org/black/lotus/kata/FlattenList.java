package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.List;
import org.black.lotus.marker.Easy;
import org.black.lotus.marker.FirstRound;
import org.black.lotus.marker.LintCode;

/** TODO */
@FirstRound
@LintCode
@Easy
public class FlattenList {
  public List<Integer> flatten(List<NestedInteger> nestedList) {
    List<Integer> res = new ArrayList<>();
    for (NestedInteger i : nestedList) {
      if (i.isInteger()) {
        res.add(i.getInteger());
      }
      List<NestedInteger> list = i.getList();
      if (list != null) {}
    }
    return res;
  }
}
