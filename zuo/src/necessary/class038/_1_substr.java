package necessary.class038;

import java.util.HashSet;

/**
 *ClassName: _1_substr
 *Package: necessary.class038
 *Description:创建于 2025/10/22 21:54
 * https://www.nowcoder.com/practice/92e6247998294f2c933906fdedbc6e6a
 *@Author lyl
 *@Version 1.0
 */
public class _1_substr {
}

class Solution1 {
    public String[] generatePermutation (String s) {
        // write code here
        if (s.isEmpty()) {
            return new String[] {""};
        }
        HashSet<String> set = new HashSet<>();
        String[] strings = generatePermutation(s.substring(1));
        for (String str : strings) {
            set.add(str);
            set.add(s.charAt(0) + str);
        }
        String[] ans = new String[set.size()];
        int i = 0;
        for (String str : set) {
            ans[i++] = str;
        }
        return ans;
    }
}