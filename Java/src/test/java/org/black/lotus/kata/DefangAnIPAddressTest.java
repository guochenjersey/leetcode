package org.black.lotus.kata;

import org.junit.Test;

import static org.junit.Assert.*;

public class DefangAnIPAddressTest {

    @Test
    public void should_do_valid_defang_ip() {
        String ip = "255.0.255.0";
        DefangAnIPAddress defangAnIPAddress = new DefangAnIPAddress();

        assertEquals("255[.]0[.]255[.]0", defangAnIPAddress.defangIPaddr(ip));
    }
}