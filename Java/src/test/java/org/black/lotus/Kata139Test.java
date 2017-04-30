package org.black.lotus;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import org.junit.Test;

import static org.junit.Assert.*;

public class Kata139Test {

    @Test
    public void test_139() {
        ImmutableSet<String> dict = ImmutableSet.of("a", "ab", "abc", "abcd", "qefjao");
        Kata139 kata139 = new Kata139();
        kata139.wordBreak("a", dict);
    }
}