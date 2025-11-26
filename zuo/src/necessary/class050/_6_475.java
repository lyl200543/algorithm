package necessary.class050;

import java.util.Arrays;

/**
 *ClassName: _6_475
 *Package: necessary.class050
 *Description:创建于 2025/11/26 20:10
 * https://leetcode.cn/problems/heaters/
 *@Author lyl
 *@Version 1.0
 */
public class _6_475 {
}
class Solution6 {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int l = 0, r = 0;
        int min = 0;
        for (l = 0; l < houses.length; l++) {
            while (!best(houses, heaters, l, r)) {
                r++;
            }
            min = Math.max(min, Math.abs(heaters[r] - houses[l]));
        }
        return min;
    }

    private boolean best(int[] houses, int[] heaters, int l, int r) {
        return r == heaters.length - 1 ||
                Math.abs(heaters[r] - houses[l]) < Math.abs(heaters[r + 1] - houses[l]);
    }
}