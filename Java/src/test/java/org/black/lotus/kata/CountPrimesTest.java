package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesTest {

    @Test
    public void should_find_primes() {
        CountPrimes countPrimes = new CountPrimes();
        int res = countPrimes.countPrimes(10);

        assertEquals(4, res);
        assertEquals(1, countPrimes.countPrimes(3));
    }
}