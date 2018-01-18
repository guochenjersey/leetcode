package org.black.lotus.lintcode;

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

public class KnightShortestPath {
  public int shortestPath(boolean[][] grid, Point source, Point destination) {
    return -1;
  }
}
