package org.black.lotus.kata;

import java.util.ArrayList;
import org.black.lotus.marker.Amazon;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.LintCode;
import org.black.lotus.marker.NoIdeaOrBadIdeaInitially;
import org.black.lotus.org.black.lotus.support.TreeNode;

/**
 * Design an algorithm and write code to serialize and deserialize a binary tree. Writing the tree
 * to a file is called 'serialization' and reading back from the file to reconstruct the exact same
 * binary tree is 'deserialization'.
 *
 * <p>Notice There is no limit of how you deserialize or serialize a binary tree, LintCode will take
 * your output of serialize as the input of deserialize, it won't check the result of serialize.
 *
 * <p>Have you met this question in a real interview? Example An example of testdata: Binary tree
 * {3,9,20,#,#,15,7}, denote the following structure:
 *
 * <p>3 / \ 9 20 / \ 15 7 Our data serialization use bfs traversal. This is just for when you got
 * wrong answer and want to debug the input.
 *
 * <p>You can use other method to do serializaiton and deserialization.
 *
 * <p>Tags Related Problems
 */
@LintCode
@Amazon
@Important
@NoIdeaOrBadIdeaInitially
public class BinaryTreeSerialization {

  /**
   * This method will be invoked first, you should design your own algorithm to serialize a binary
   * tree which denote by a root node to a string which can be easily deserialized by your own
   * "deserialize" method later.
   */
  public String serialize(TreeNode root) {
    if (root == null) {
      return "{}";
    }
    ArrayList<TreeNode> queue = new ArrayList<>();
    queue.add(root);

    for (int i = 0; i < queue.size(); ++i) {
      TreeNode node = queue.get(i);
      if (node == null) {
        continue;
      }
      queue.add(node.left);
      queue.add(node.right);
    }

    while (queue.get(queue.size() - 1) == null) {
      queue.remove(queue.size() - 1);
    }
    StringBuilder sb = new StringBuilder();
    sb.append("{").append(queue.get(0).val);
    for (int i = 1; i < queue.size(); ++i) {
      if (queue.get(i) == null) {
        sb.append(",#");
      } else {
        sb.append(",").append(queue.get(i).val);
      }
    }

    sb.append("}");
    return sb.toString();
  }

  /**
   * This method will be invoked second, the argument data is what exactly you serialized at method
   * "serialize", that means the data is not given by system, it's given by your own serialize
   * method. So the format of data is designed by yourself, and deserialize it here as you serialize
   * it in "serialize" method.
   */
  public TreeNode deserialize(String data) {
    if (data == null || data.equals("{}")) {
      return null;
    }
    String[] vals = data.substring(1, data.length() - 1).split(",");
    ArrayList<TreeNode> queue = new ArrayList<>();
    TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    queue.add(root);
    int index = 0;
    boolean isLeftChild = true;
    for (int i = 1; i < vals.length; ++i) {
      TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
      if (isLeftChild) {
        queue.get(index).left = node;
      } else {
        queue.get(index).right = node;
      }
      if (!isLeftChild) {
        ++index;
      }
      isLeftChild = !isLeftChild;
    }
    return root;
  }
}
