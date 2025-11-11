package necessary.class059;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *ClassName: _4_114
 *Package: necessary.class059
 *Description:创建于 2025/11/11 20:42
 *  https://leetcode.cn/problems/Jf1JuT/
 *@Author lyl
 *@Version 1.0
 */
public class _4_114 {
}

class Solution4 {
    public String alienOrder(String[] words) {
        int[] inDegree = new int[26];
        Arrays.fill(inDegree, -1);
        for (String s : words) {
            char[] array = s.toCharArray();
            for (int i = 0; i < array.length; i++) {
                inDegree[array[i] - 'a'] = 0;
            }
        }
        int size = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                size++;
            }
        }
        //建图
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            graph.add(new ArrayList<>());
        }
        //加边
        for (int i = 0, j; i < words.length - 1; i++) {
            j = i + 1;
            int len = Math.min(words[i].length(), words[j].length());
            int k;
            for (k = 0; k < len; k++) {
                if (words[i].charAt(k) != words[j].charAt(k)) {
                    graph.get(words[i].charAt(k) - 'a').add(words[j].charAt(k) - 'a');
                    inDegree[words[j].charAt(k) - 'a']++;
                    break;
                }
            }
            //abcd  abc 的情况处理
            if (k < words[i].length() && k == words[j].length()) {
                return "";
            }
        }
        int[] queue = new int[size];
        int l = 0, r = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue[r++] = i;
            }
        }
        StringBuilder ans = new StringBuilder();
        while (l < r) {
            int str = queue[l++];
            ans.append((char) (str + 'a'));
            for (int neighbor : graph.get(str))
                if (--inDegree[neighbor] == 0) {
                    queue[r++] = neighbor;
                }
        }
        return ans.length() == size ? ans.toString() : "";
    }
}