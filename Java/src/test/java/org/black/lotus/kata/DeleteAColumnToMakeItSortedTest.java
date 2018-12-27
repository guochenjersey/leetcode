package org.black.lotus.kata;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class DeleteAColumnToMakeItSortedTest {

    @Test
    public void should_be_non_descending() {
        String[] source = {"a", "b"};
        DeleteAColumnToMakeItSorted deleteAColumnToMakeItSorted =
                new DeleteAColumnToMakeItSorted();
        int res = deleteAColumnToMakeItSorted.minDeletionSize(source);
        String[] source1 = {"rrjk", "furt", "guzm"};
        int res2 = deleteAColumnToMakeItSorted.minDeletionSize(source1);

        assertEquals(0, res);
        assertEquals(2, res2);
        Map<String, String> map = new HashMap<>();
    }
}