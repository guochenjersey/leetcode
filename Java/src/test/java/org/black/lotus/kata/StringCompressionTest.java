package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringCompressionTest {

    @Test
    public void should_compress_string() {
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c',};
        StringCompression stringCompression = new StringCompression();
        int res = stringCompression.compress(chars);

    }
}