package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringCompressionTest {

  @Test
  public void should_compress_string() {
    char[] chars = {
      'a', 'a', 'b', 'b', 'c', 'c', 'c',
    };
    StringCompression stringCompression = new StringCompression();
    int res = stringCompression.compress(chars);
  }
}
