package org.black.lotus.kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class KillProcessTest {

    @Test
    public void should_find_all_process_to_kill() {
        List<Integer> pid = Arrays.asList(1, 3, 10, 5);
        List<Integer> ppid = Arrays.asList(3, 0, 5, 3);
        KillProcess killProcess = new KillProcess();
        List<Integer> res = killProcess.killProcess(pid, ppid, 5);
        List<Integer> expectedRes = Arrays.asList(5, 10);

        assertEquals(expectedRes, res);

        List<Integer> pid1 = Arrays.asList(1, 2, 3);
        List<Integer> ppid1 = Arrays.asList(0, 1, 1);

        List<Integer> res1 = killProcess.killProcess(pid1, ppid1, 2);
        List<Integer> expectedRes1 = Arrays.asList(2);
        assertEquals(expectedRes1, res1);

        List<Integer> pid2 = Arrays.asList(8, 6, 7, 9, 2, 4);
        List<Integer> ppid2 = Arrays.asList(9, 7, 0, 6, 7, 6);
        List<Integer> res2 = killProcess.killProcess(pid2, ppid2, 7);

        List<Integer> expectedRes2 = Arrays.asList(2, 4, 6, 7, 8, 9);
        Collections.sort(res2);
        assertEquals(expectedRes2, res2);
    }
}