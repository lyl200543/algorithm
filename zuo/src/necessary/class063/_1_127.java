package necessary.class063;

import java.util.HashSet;
import java.util.List;

/**
 *ClassName: _1_127
 *Package: necessary.class063
 *Description:创建于 2025/11/30 22:00
 * https://leetcode.cn/problems/word-ladder/
 * 双向广搜：
 * 1.优化：剪枝 ->两边同时bfs,每次选跟小的一边bfs，直到相遇
 *@Author lyl
 *@Version 1.0
 */
public class _1_127 {
}
class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return 0;
        }
        HashSet<String> smallLevel = new HashSet<>();
        HashSet<String> bigLevel = new HashSet<>();
        HashSet<String> nextLevel = new HashSet<>();
        smallLevel.add(beginWord);
        bigLevel.add(endWord);
        for (int level = 2; !smallLevel.isEmpty(); level++) {
            for (String word : smallLevel) {
                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char old = arr[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != old) {
                            arr[i] = c;
                            String str = String.valueOf(arr);
                            if (bigLevel.contains(str)) {
                                return level;
                            }
                            if (words.contains(str)) {
                                words.remove(str);
                                nextLevel.add(str);
                            }
                        }
                    }
                    arr[i] = old;
                }
            }
            if (nextLevel.size() <= bigLevel.size()) {
                HashSet<String> tmp = smallLevel;
                smallLevel = nextLevel;
                nextLevel = tmp;
            } else {
                smallLevel = bigLevel;
                bigLevel = nextLevel;
                nextLevel = new HashSet<>();
            }
            nextLevel.clear();
        }
        return 0;
    }
}