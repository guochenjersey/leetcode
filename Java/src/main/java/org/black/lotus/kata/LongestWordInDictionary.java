package org.black.lotus.kata;

import org.black.lotus.marker.Google;
import org.black.lotus.marker.Important;
import org.black.lotus.marker.NotAccepted;

import java.util.HashMap;
import java.util.Stack;

/**
 *
 * Trie，又称单词查找树或键树，是一种树形结构。典型应用是用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。它的优点是：最大限度地减少无谓的字符串比较，查询效率比哈希表高。



 它有3个基本性质：

 1.根节点不包含字符，除根节点外每一个节点都只包含一个字符。

 2.从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。

 3.每个节点的所有子节点包含的字符都不相同。



 Trie中每个节点有一个特殊标记作为结束符号，通过该标记可以判断当前节点是否是一个字符串的终结节点。

 * */
@NotAccepted @Google @Important
public class LongestWordInDictionary {

  public String longestWord(String[] words) {
    Trie trie = new Trie(words);
    int index = 0;
    for (String word: words) {
      trie.insert(word, ++index); //indexed by 1
    }
    return trie.dfs();
  }

  public static void main(String... args) {
    String[] dictonaryWords = new String[]{"world", "bb", "wo", "wor", "worl"};
    LongestWordInDictionary trieTree = new LongestWordInDictionary();
    System.out.println(trieTree.longestWord(dictonaryWords));
  }
}

class TrieNode {
  char c;
  HashMap<Character, TrieNode> children = new HashMap();
  int end;  // end非零表示这是一个终结节点，且end-1对应的就是该word在words中的索引
  public TrieNode(char c){
    this.c = c;
  }
}

class Trie {
    TrieNode root;
    String[] words;
  public Trie(String[] words) {
    root = new TrieNode('0');
    this.words = words;
  }

  public void insert(String word, int index) {
      TrieNode cur = root;
    for (char c : word.toCharArray()) {
      cur.children.putIfAbsent(c, new TrieNode(c));
      cur = cur.children.get(c);
    }
    cur.end = index;
  }

  public String dfs() {
    String ans = "";
    Stack<TrieNode> stack = new Stack();
    stack.push(root);
    while (!stack.empty()) {
        TrieNode node = stack.pop();
      if (node.end > 0 || node == root) {
        if (node != root) {
          String word = words[node.end - 1];
          if (word.length() > ans.length() ||
              word.length() == ans.length() && word.compareTo(ans) < 0) {
            ans = word;
          }
        }
        for (TrieNode nei: node.children.values()) {
          stack.push(nei);
        }
      }
    }
    return ans;
  }
}