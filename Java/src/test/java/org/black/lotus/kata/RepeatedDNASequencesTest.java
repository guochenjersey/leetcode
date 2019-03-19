package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class RepeatedDNASequencesTest {

  @Test
  public void test_repeated_dna_sequence_test() {
    RepeatedDNASequences repeatedDNASequences = new RepeatedDNASequences();
    List<String> res =
        repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
    assertEquals(2, res.size());
    repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAA");
  }
}
