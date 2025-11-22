package necessary.class062;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *ClassName: _2_691
 *Package: necessary.class062
 *Description:创建于 2025/11/21 22:12
 * https://leetcode.cn/problems/stickers-to-spell-word/
 * 思路：
 * 难！！！！！！！！！！！！！！！！！！！
 * 1.目标分别减去所有贴纸得到的字符串为下一层要遍历的目标,直到某一层有字符串为空，则找到最小的贴纸数
 * 2.剪枝：可通过按目标的前缀来筛选（都排序，方便筛选）
 *@Author lyl
 *@Version 1.0
 */
public class _2_691 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.minStickers(new String[]{"notice","possible"}, "basicbasic"));
    }
}
class Solution2 {
    private final int MAXN = 1001;
    private String[] queue = new String[MAXN];
    private int l, r;
    private static ArrayList<ArrayList<String>> index = new ArrayList<>();
    private Set<String> visited = new HashSet<>();

    static {
        for (int i = 0; i < 26; i++) {
            index.add(new ArrayList<>());
        }
    }

    public int minStickers(String[] stickers, String target) {
        //清理：
        for (int i = 0; i < 26; i++) {
            index.get(i).clear();
        }
        visited.clear();
        target = sort(target);
        for (String s : stickers) {
            s = sort(s);
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 || s.charAt(i) != s.charAt(i - 1)) {
                    index.get(s.charAt(i) - 'a').add(s);
                }
            }
        }
        l = r = 0;
        queue[r++] = target;
        visited.add(target);
        int level = 1;
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                String cur = queue[l++];
                for (String s : index.get(cur.charAt(0) - 'a')) {
                    String next = next(cur, s);
                    if (next.isEmpty()) {
                        return level;
                    } else if (!visited.contains(next)) {
                        visited.add(next);
                        queue[r++] = next;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    private String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }

    /**return a string of t-s */
    private String next(String t, String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < t.length();) {
            if (j == s.length()) {
                sb.append(t.charAt(i++));
            } else {
                if (t.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else if (t.charAt(i) < s.charAt(j)) {
                    sb.append(t.charAt(i));
                    i++;
                } else {
                    j++;
                }
            }

        }
        return sb.toString();
    }
}