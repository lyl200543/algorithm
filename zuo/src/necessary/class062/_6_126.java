package necessary.class062;

import java.util.*;

/**
 *ClassName: _6_126
 *Package: necessary.class062
 *Description:创建于 2025/11/27 18:57
 * https://leetcode.cn/problems/word-ladder-ii/
 * bfs与dfs结合
 *@Author lyl
 *@Version 1.0
 */
public class _6_126 {
}

class Solution6 {
    private List<List<String>> ans = new ArrayList<>();
    private HashSet<String> dict = new HashSet<>();
    //bfs
    private HashSet<String> curLevel = new HashSet<>();
    private HashSet<String> nextLevel = new HashSet<>();
    //dfs:反向图
    private HashMap<String, ArrayList<String>> graph = new HashMap<>();
    private LinkedList<String> path = new LinkedList<>();

    private void build(List<String> wordList) {
        dict = new HashSet<>(wordList);
        ans.clear();
        curLevel.clear();
        nextLevel.clear();
        graph.clear();
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        build(wordList);
        if (!dict.contains(endWord)) {
            return ans;
        }
        if (bfs(beginWord, endWord)) {
            dfs(endWord, beginWord);
        }
        return ans;
    }

    private boolean bfs(String beginWord, String endWord) {
        curLevel.add(beginWord);
        while (!curLevel.isEmpty()) {
            dict.removeAll(curLevel);
            boolean flag = false;
            for (String word : curLevel) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char oldChar = arr[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        arr[i] = j;
                        String str = String.valueOf(arr);
                        if (dict.contains(str)) {
                            if (str.equals(endWord)) {
                                flag = true;
                            }
                            graph.putIfAbsent(str, new ArrayList<>());
                            graph.get(str).add(word);
                            nextLevel.add(str);
                        }
                    }
                    arr[i] = oldChar;
                }
            }
            if (flag) {
                return true;
            } else {
                HashSet<String> tmp = curLevel;
                curLevel = nextLevel;
                nextLevel = tmp;
                nextLevel.clear();
            }
        }
        return false;
    }

    private void dfs(String word, String aim) {
        path.addFirst(word);
        if (word.equals(aim)) {
            ans.add(new ArrayList<>(path));
        } else {
            for (String next : graph.get(word)) {
                dfs(next, aim);
            }
        }
        path.removeFirst();
    }
}