package org.black.lotus.kata;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class GenerateParenthesesTest {

    @Test
    public void should_genreate() {
        GenerateParentheses generateParentheses = new GenerateParentheses();
        List<String> res = generateParentheses.generateParenthesis(3);

        assertEquals(5, res);
    }
}