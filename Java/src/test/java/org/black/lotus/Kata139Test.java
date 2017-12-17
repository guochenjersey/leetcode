package org.black.lotus;

import static org.junit.Assert.*;

import com.google.common.collect.ImmutableSet;
import org.junit.Test;

public class Kata139Test {

  @Test
  public void test_139() {
    ImmutableSet<String> dict = ImmutableSet.of("a", "ab", "abc", "abcd", "qefjao");
    Kata139 kata139 = new Kata139();
    kata139.wordBreak("a", dict);
  }
}
