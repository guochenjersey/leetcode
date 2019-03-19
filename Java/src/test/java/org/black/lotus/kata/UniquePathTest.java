package org.black.lotus.kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class UniquePathTest {

  @Test
  public void should_find_unique_path() {
    UniquePath up1 = new UniquePath();
    UniquePath up2 = new UniquePath();
    UniquePath up3 = new UniquePath();
    UniquePath up4 = new UniquePath();

    assertEquals(3, up1.uniquePathsDFS(3, 2));
    assertEquals(28, up2.uniquePathsDFS(7, 3));
    assertEquals(1, up3.uniquePathsDFS(1, 3));
    assertEquals(1, up4.uniquePathsDFS(51, 9));
  }
}
