package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RepeatedDNASequencesTest {

    @Test
    public void test_repeated_dna_sequence_test() {
        RepeatedDNASequences repeatedDNASequences =
                new RepeatedDNASequences();
        List<String> res = repeatedDNASequences.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        assertEquals(2, res.size());
        repeatedDNASequences.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}