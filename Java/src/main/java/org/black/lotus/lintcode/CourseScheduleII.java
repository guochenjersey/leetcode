package org.black.lotus.lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseScheduleII {

  class CircleException extends Exception {

  }
  /**
   * @param numCourses: a total of n courses
   * @param prerequisites: a list of prerequisite pairs
   * @return: the course order
   */
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> prerequisitesMap = toMap(prerequisites);

    for (int i = 0 ; i< numCourses; ++i) {
      Queue<Integer> queue = new LinkedList<>();
      queue.offer(i);
      Set<Integer> coursesSet = initCoursesSet(numCourses);
      List<Integer> res = new LinkedList<>();
      try {
        findAllCourses(queue, prerequisitesMap, numCourses, res, coursesSet);
      } catch (CircleException e) {
        return new int[0];
      }
      if (res.size() == numCourses && coursesSet.size() == 0) {
        int[] resArray = new int[res.size()];
        for (int j = 0; j < res.size(); ++j) {
          resArray[j] = res.get(j);
        }

        return resArray;
      }
    }

    return new int[0];
  }

  private void findAllCourses(Queue<Integer> queue,
      Map<Integer, List<Integer>> prerequisitesMap,
      int numCourses,
      List<Integer> res,
      Set<Integer> courseSet) throws CircleException {
    int visitedCourses = 0;
    while (!queue.isEmpty()) {
      if (visitedCourses < numCourses) {
        Integer course = queue.poll();
        courseSet.remove(course);
        res.add(course);
        visitedCourses++;
        prerequisitesMap.getOrDefault(course, new ArrayList<>()).forEach(queue::offer);
      } else {
        throw new CircleException();
      }
    }
  }

  private Map<Integer, List<Integer>> toMap(int[][] prerequisites) {
    Map<Integer, List<Integer>> prerequisiteMap = new HashMap<>();

    for (int[] prerequisite : prerequisites) {
      prerequisiteMap.putIfAbsent(prerequisite[1], new ArrayList<>());
      prerequisiteMap.get(prerequisite[1]).add(prerequisite[0]);
    }

    return prerequisiteMap;
  }

  private Set<Integer> initCoursesSet(int numCourses) {
    Set<Integer> coursesSet = new HashSet<>();
    for (int i = 0; i < numCourses; ++i) {
      coursesSet.add(i);
    }

    return coursesSet;
  }

  public static void main(String... args) {
    int[][] pre = {{5,8},{3,5},{1,9},{4,5},{0,2},{1,9},{7,8},{4,9}};
    CourseScheduleII courseScheduleII = new CourseScheduleII();
    int[] order = courseScheduleII.findOrder(10, pre);
    for (int i = 0; i < order.length; i++) {
      System.out.println(order[i]);
    }
  }
}
