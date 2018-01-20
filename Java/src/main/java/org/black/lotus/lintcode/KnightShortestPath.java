package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Point {
  public int x, y;
  public Point() { x = 0; y = 0; }
  public Point(int a, int b) { x = a; y = b; }

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

class KnightCoordinate {
  private Point point;

  public KnightCoordinate(Point point) {
    this.point = point;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    KnightCoordinate that = (KnightCoordinate) o;

    return point != null ? (point.x == that.point.x && point.y == that.point.y)
        : that.point == null;
  }

  @Override
  public int hashCode() {
    return point.x + point.y;
  }
}

public class KnightShortestPath {

  private static final int NOT_FOUND = -1;
  int[][] directions = {
      {-1, 2},
      {-2, 1},
      {-2, -1},
      {-1, -2},
      {1, 2},
      {1, -2},
      {2, 1},
      {2, -1}
  };


  private List<Point> getNextPoints(boolean[][] grid, Point point) {
    List<Point> result = new ArrayList<>();

    for (int[] direction : directions) {
      int nextX = point.x + direction[0];
      int nextY = point.y + direction[1];
      boolean withinChessboardRow = nextX >= 0 && nextX < grid.length;
      boolean withinChessboardColumn = nextY >= 0 && nextY < grid[0].length;
      if (withinChessboardColumn && withinChessboardRow && !grid[nextX][nextY]) {
        result.add(new Point(nextX, nextY));
      }
    }

    return result;
  }

  public int shortestPath(boolean[][] grid, Point source, Point destination) {
    Queue<Point> queue = new LinkedList<>();
    queue.offer(source);
    Set<KnightCoordinate> visitedPoints = new HashSet<>();
    return helper(queue, visitedPoints, destination, grid);
  }

  private int helper(Queue<Point> queue,
      Set<KnightCoordinate> visitedPoints,
      Point destination,
      boolean[][] grid) {
    int step = 0;
    while (!queue.isEmpty()) {
      int queueSize = queue.size();
      for (int i = 0; i < queueSize; ++i) {
        // traverse current level
        Point point = queue.poll();
        if (isSamePoint(point, destination)) {
          return step;
        }
        if (visitedPoints.contains(new KnightCoordinate(point))) {
          // loop exists and exit.
          return NOT_FOUND;
        }
        grid[point.x][point.y] = true;
        getNextPoints(grid, point).forEach(queue::offer);
      }
      ++step;
    }
    return NOT_FOUND;
  }

  private boolean isSamePoint(Point left, Point right) {
    return left.x == right.x && left.y == right.y;
  }

  private void test() {
    boolean[][] grid = {{false,true,true,false,false,false,false,true,true,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,true,true,true,false,false,false,false,false,true,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,true,false,false,false,true,false,true,true,true,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{true,true,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,true,false,false,false,false,false,true,true,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,true,true,false,false,true,true,false,false,true,false,true,false,false,false,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,true,false,false,false,true,false,false,false,false,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,true,true,false,false,false,false,true,false,false,false,true,true,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,true,true,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,true,false,false,false,false,false,true,false,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{true,false,true,false,false,false,false,false,true,true,false,true,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,true,true,false,true,false,false,true,false,true,false,true,true,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,true,false,false,false,false,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,true,false,false,false,false,false,false,false,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,true,false,false,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{true,true,false,true,true,false,false,true,false,false,false,false,true,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{true,false,false,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,true,false,false,false,false,true,false,true,false,false,false,true,true,false,true,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{true,true,false,false,true,false,false,false,false,false,false,false,false,true,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,true,true,true,false,true,false,false,true,true,false,false,true,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false},{false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false}};

    Point start = new Point(15, 10);
    Point destination = new Point(36, 21);
    System.out.println(shortestPath(grid, start, destination));
  }

  public static void main(String... args) {
    KnightShortestPath knightShortestPath = new KnightShortestPath();
    knightShortestPath.test();
  }
}


class Solution {
  int n, m; // size of the chessboard
  int[] deltaX = {1, 1, 2, 2, -1, -1, -2, -2};
  int[] deltaY = {2, -2, 1, -1, 2, -2, 1, -1};
  /**
   * @param grid a chessboard included 0 (false) and 1 (true)
   * @param source, destination a point
   * @return the shortest path
   */
  public int shortestPath(boolean[][] grid, Point source, Point destination) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) {
      return -1;
    }

    n = grid.length;
    m = grid[0].length;

    Queue<Point> queue = new LinkedList<>();
    queue.offer(source);

    int steps = 0;
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Point point = queue.poll();
        if (point.x == destination.x && point.y == destination.y) {
          return steps;
        }

        for (int direction = 0; direction < 8; direction++) {
          Point nextPoint = new Point(
              point.x + deltaX[direction],
              point.y + deltaY[direction]
          );

          if (!inBound(nextPoint, grid)) {
            continue;
          }

          queue.offer(nextPoint);
          // mark the point not accessible
          grid[nextPoint.x][nextPoint.y] = true;
        }
      }
      steps++;
    }

    return -1;
  }

  private boolean inBound(Point point, boolean[][] grid) {
    if (point.x < 0 || point.x >= n) {
      return false;
    }
    if (point.y < 0 || point.y >= m) {
      return false;
    }
    return (grid[point.x][point.y] == false);
  }

  public void test() {
    boolean[][] grid = {
        {false, false, false},
        {false, false, false},
        {false, false, false}
    };

    Point start = new Point(2, 0);
    Point destination = new Point(2, 2);
    System.out.println(shortestPath(grid, start, destination));
  }
}
