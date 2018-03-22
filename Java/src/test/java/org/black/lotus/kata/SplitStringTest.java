package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SplitStringTest {

    @Test
    public void should_list_all_probablities() {
        SplitString splitString = new SplitString();
        List<List<String>> res = splitString.splitString("123");
        res.stream().forEach(list -> {
            list.stream().forEach(System.out::println);
        });
    }
}