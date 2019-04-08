package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PartionLabelsTest {

    @Test
    public void should_find_partion_label() {
        PartionLabels partionLabels = new PartionLabels();
        List<Integer> res = partionLabels.partitionLabels("ababcbacadefegdehijhklij");
        res.forEach(System.out::println);
    }
}