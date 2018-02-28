package org.black.lotus.kata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

class Coordinate {

  static int ROW_LIMIT = -1;
  static int COLUMN_LIMIT = -1;

  private int x;
  private int y;

  Coordinate(int x, int y) {
    this.x = x;
    this.y = y;
  }

  Optional<Coordinate> up() {
    if (x - 1 >= 0) {
      return Optional.of(new Coordinate(x - 1, y));
    }

    return Optional.empty();
  }

  Optional<Coordinate> down() {
    if (x + 1 < ROW_LIMIT) {
      return Optional.of(new Coordinate(x + 1, y));
    }

    return Optional.empty();
  }

  Optional<Coordinate> left() {
    if (y - 1 >= 0) {
      return Optional.of(new Coordinate(x, y - 1));
    }

    return Optional.empty();
  }

  Optional<Coordinate> right() {
    if (y + 1 < COLUMN_LIMIT) {
      return Optional.of(new Coordinate(x, y + 1));
    }

    return Optional.empty();
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Coordinate that = (Coordinate) o;

    if (x != that.x) {
      return false;
    }
    return y == that.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}

class Chessboard {

  private static int HUMAN = 0;
  private static int ZOMBIE = 1;
  private static int WALL = 2;

  private int zombieBreedingDays;
  private int currentZombie;
  private Map<Coordinate, Integer> chessBoard;


  Chessboard(int[][] grid) {
    chessBoard = new HashMap<>();
    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[i].length; ++j) {
        chessBoard.put(new Coordinate(i, j), grid[i][j]);
      }
    }
    currentZombie = Integer.MIN_VALUE;
    zombieBreedingDays = 0;
  }

  void zombieBreeding() {
    while (true) {
      List<Coordinate> zombies = getZombies();
      if (isAllMarked()) {
        return;
      }
      if (zombies.size() == currentZombie) {
        return;
      }

      ++zombieBreedingDays;
      currentZombie = zombies.size();
      zombies.forEach(zombie -> {
        zombie.left().ifPresent(this::markZombie);
        zombie.right().ifPresent(this::markZombie);
        zombie.up().ifPresent(this::markZombie);
        zombie.down().ifPresent(this::markZombie);
      });
    }
  }

  List<Coordinate> getCooridinates(Integer key) {
    List<Coordinate> coordinates = new ArrayList<>();
    chessBoard.entrySet().stream().forEach(entry -> {
      if (entry.getValue().equals(key)) {
        coordinates.add(entry.getKey());
      }
    });
    return coordinates;
  }

  List<Coordinate> getWalls() {
    return getCooridinates(WALL);
  }

  List<Coordinate> getZombies() {
    return getCooridinates(ZOMBIE);
  }

  void markZombie(Coordinate coordinate) {
    Integer species = chessBoard.get(coordinate);
    if (species.equals(HUMAN)) {
      chessBoard.put(coordinate, ZOMBIE);
    }
  }

  int getZombieBreedingResult() {
    zombieBreeding();
    return isAllMarked()
        ? zombieBreedingDays : -1;
  }

  boolean isAllMarked() {
    List<Coordinate> zombies = getZombies();
    List<Coordinate> walls = getWalls();
    return chessBoard.keySet().size() == (zombies.size() + walls.size());
  }
}


public class ZombieInMatrix {

  public int zombie(int[][] grid) {
    Coordinate.ROW_LIMIT = grid.length;
    Coordinate.COLUMN_LIMIT = grid[0].length;
    Chessboard chessBoard = new Chessboard(grid);
    return chessBoard.getZombieBreedingResult();
  }

  public static void main(String... args) {
    int[][] grid = {
        {0, 1, 2, 0, 0},
        {1, 0, 0, 2, 1},
        {0, 1, 0, 0, 0}
    };

    ZombieInMatrix zombieInMatrix = new ZombieInMatrix();
    int zombie = zombieInMatrix.zombie(grid);
    System.out.println(zombie);
  }
}
