package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class KthPrimeNumberTest {

    @Test
    public void should_find_kth_prime_numbers() {
        KthPrimeNumber kthPrimeNumber = new KthPrimeNumber();
        assertEquals(1, kthPrimeNumber.kthPrime(2));
        assertEquals(5, kthPrimeNumber.kthPrime(11));
    }
}