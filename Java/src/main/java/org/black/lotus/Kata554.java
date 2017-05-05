package org.black.lotus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * <p>
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.
 * <p>
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * <p>
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 * <p>
 * Example:
 * Input:
 * [[1,2,2,1],
 * [3,1,2],
 * [1,3,2],
 * [2,4],
 * [3,1,2],
 * [1,3,1,1]]
 * Output: 2
 * Explanation:
 */
public class Kata554 {

    public int leastBricks(List<List<Integer>> wall) {
        if (wall == null || wall.size() == 0) {
            return 0;
        }

        List<HashMap<Integer, Integer>> rowMaps = new ArrayList<>();

        wall.stream().forEach(row -> {
            HashMap<Integer, Integer> transformedRow = new HashMap<>();
            Integer rowIndex = 0;
            for (int i = 0; i < row.size(); i++) {
                Integer brick = row.get(i);
                while (brick > 0) {
                    transformedRow.put(rowIndex, 1);
                    rowIndex++;
                    brick--;
                    // fill the gap of the brick
                    if (brick > 0) {
                        transformedRow.put(rowIndex, 1);
                        rowIndex++;
                    }
                }
                if (i < row.size() - 1) {
                    // fill the gap with next brick
                    transformedRow.put(rowIndex++, 0);
                }
            }
            rowMaps.add(transformedRow);
        });

        int minSoFar = Integer.MAX_VALUE;
        int columnNumbers = rowMaps.get(0).size();
        int rowNumbers = rowMaps.size();
        for (int i = 0; i < columnNumbers; ++i) {
            int bricks = 0;
            for (int j = 0; j < rowNumbers; ++j) {
                Integer value = rowMaps.get(j).getOrDefault(i, 0);
                bricks += value;
            }
            minSoFar = Math.min(bricks, minSoFar);
        }

        return minSoFar;
    }
}
