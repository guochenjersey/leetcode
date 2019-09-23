package org.black.lotus.kata;

import org.black.lotus.marker.Easy;
import org.black.lotus.marker.LeetCode;
import org.black.lotus.marker.LintCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * In this problem, each process has a unique PID (process id) and PPID (parent process id).
 *
 * Each process only has one parent process, but may have one or more children processes. This is just like a tree structure. Only one process has PPID that is 0, which means this process has no parent process. All the PIDs will be distinct positive integers.
 *
 * We use two list of integers to represent a list of processes, where the first list contains PID for each process and the second list contains the corresponding PPID.
 *
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of processes that will be killed in the end. You should assume that when a process is killed,
 * all its children processes will be killed. No order is required for the final answer.
 *
 * Example
 * Example 1:
 *
 * Input: PID = [1, 3, 10, 5], PPID = [3, 0, 5, 3], killID = 5
 * Output: [5, 10]
 * Explanation: Kill 5 will also kill 10.
 *      3
 *    /   \
 *   1     5
 *        /
 *       10
 * */
@LeetCode
@LintCode
@Easy
public class KillProcess {

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        if (kill == 0) {
            return pid;
        }
        Node root = constructDependencies(pid, ppid);
        List<Integer> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while ((root = queue.poll())!= null) {
            if (root.val == kill) {
                break;
            } else {
                for (Node n : root.children) {
                    queue.offer(n);
                }
            }
        }

        if (root == null) {
            return new ArrayList<>();
        }

        queue.clear();
        queue.offer(root);
        while ((root = queue.poll()) != null) {
            res.add(root.val);
            for (Node n : root.children) {
                queue.offer(n);
            }
        }

        return res;
    }

    private Node constructDependencies(List<Integer> pids, List<Integer> ppids) {
        Node root = new Node(0);
        List<Node> nodes = new ArrayList<>();
        nodes.add(root);
        for (Integer p : pids) {
            nodes.add(new Node(p));
        }

        for (int i = 0; i < ppids.size(); ++i) {
            int ppid = ppids.get(i);
            Node ppidNode = nodes.stream().filter(n -> n.val == ppid).findFirst().get();
            ppidNode.children.add(nodes.get(i + 1));
        }

        return root;
    }


    class Node implements Comparable {
        int val;
        Set<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new HashSet<>();
        }


        public String toString() {
            return String.valueOf(val);
        }

        @Override
        public int compareTo(Object o) {
            return this.val - ((Node)o).val;
        }
    }
}
