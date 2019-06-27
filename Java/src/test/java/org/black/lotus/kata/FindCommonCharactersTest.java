package org.black.lotus.kata;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindCommonCharactersTest {

    @Test
    public void should_find_common_character() {
        FindCommonCharacters findCommonCharacters = new FindCommonCharacters();

        List<String> expected = new ArrayList<>();
        expected.add("e");
        expected.add("l");
        expected.add("l");
        String[] source1 = {"bella", "label", "roller"};

        assertEquals(expected, findCommonCharacters.commonChars(source1));
    }

}