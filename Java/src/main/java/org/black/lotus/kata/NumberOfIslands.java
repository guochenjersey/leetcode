package org.black.lotus.kata;

import org.black.lotus.marker.Accepted;
import org.black.lotus.marker.FirstRound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 *
 * Given a boolean 2D matrix, 0 is represented as the sea, 1 is represented as the island. If two 1 is adjacent, we consider them in the same island. We only consider up/down/left/right adjacent.

 Find the number of islands.

 Have you met this question in a real interview?
 Example
 Given graph:

 [
 [1, 1, 0, 0, 0],
 [0, 1, 0, 0, 1],
 [0, 0, 0, 1, 1],
 [0, 0, 0, 0, 0],
 [0, 0, 0, 0, 1]
 ]
 return 3.

 Tags

 *
 * */
@FirstRound
@Accepted
public class NumberOfIslands {

  private class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Point point = (Point) o;

      if (x != point.x) {
        return false;
      }
      return y == point.y;
    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }
  private static int[][] directions = {
      {1, 0},
      {-1, 0},
      {0, 1},
      {0, -1}
  };

  private static int ROW_NUM;
  private static int COLUMN_NUM;

  public int numIslands(boolean[][] grid) {
    int numOfIslands = 0;
    if (grid.length == 0) {
      return numOfIslands;
    }

    ROW_NUM = grid.length;
    COLUMN_NUM = grid[0].length;

    Map<Point, Boolean> recordMap = recordMap(grid);
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        Point point = new Point(i, j);
        if (recordMap.get(point)) {
          recordMap.put(point, false);
          ++numOfIslands;
          Queue<Point> queue = new LinkedList<>();
          queue.offer(point);
          mark(recordMap, queue);
        }
      }
    }

    return numOfIslands;
  }

  private void mark(Map<Point, Boolean> recordMap, Queue<Point> queue) {
    while (!queue.isEmpty()) {
      Point point = queue.poll();
      getAdjecentIslands(point, recordMap).forEach(p -> {
        queue.offer(p);
        recordMap.put(p, false);
      });
    }
  }

  private List<Point> getAdjecentIslands(Point point, Map<Point, Boolean> recordMap) {
    List<Point> islands = new ArrayList<>();
    for (int[] direction : directions) {
      int x = point.x + direction[0];
      int y = point.y + direction[1];
      boolean withinRow = x >= 0 && x < ROW_NUM;
      boolean withinColumn = y >= 0 && y < COLUMN_NUM;
      if (withinColumn && withinRow && recordMap.get(new Point(x, y))) {
        islands.add(new Point(x, y));
      }
    }
    return islands;
  }

  private Map<Point, Boolean> recordMap(boolean[][] grid) {
    Map<Point, Boolean> recordMap = new HashMap<>();
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        // true stand for not used
        recordMap.put(new Point(i, j), grid[i][j]);
      }
    }

    return recordMap;
  }
}
