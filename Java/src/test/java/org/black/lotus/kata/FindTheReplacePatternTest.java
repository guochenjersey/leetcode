package org.black.lotus.kata;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;

public class FindTheReplacePatternTest {

  @Test
  public void should_find_correct_replacement() {
    String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
    FindTheReplacePattern findTheReplacePattern = new FindTheReplacePattern();
    List<String> res = findTheReplacePattern.findAndReplacePattern(words, "abb");
    List<String> expectedRes = Lists.newArrayList("mee", "aqq");

    assertEquals(expectedRes, res);
  }
}
