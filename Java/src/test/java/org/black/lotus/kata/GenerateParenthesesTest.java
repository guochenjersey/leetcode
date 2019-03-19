package org.black.lotus.kata;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class GenerateParenthesesTest {

  @Test
  public void should_genreate() {
    GenerateParentheses generateParentheses = new GenerateParentheses();
    List<String> res = generateParentheses.generateParenthesis(3);

    assertEquals(5, res);
  }
}
