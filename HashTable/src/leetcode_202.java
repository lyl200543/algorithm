import java.util.HashSet;

/**
 *ClassName: leetcode_202
 *Package: PACKAGE_NAME
 *Description:创建于 2025/5/10 21:19
 *@Author lyl
 *@Version 1.0
 */
public class leetcode_202 {
}

class Solution3 {
    public boolean isHappy (int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        int value = n;
        while (true) {
            int sum = 0;
            while (value / 10 != 0) {
                sum += (value % 10) * (value % 10);
                value = value / 10;
            }
            sum += value * value;
            if (sum == 1) {
                return true;
            }
            if (set.contains(sum)) {
                return false;
            }
            set.add(sum);
            value = sum;
        }
    }
}