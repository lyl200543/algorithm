package necessary.class050;

/**
 *ClassName: _2_287
 *Package: necessary.class050
 *Description:创建于 2025/11/23 21:54
 * https://leetcode.cn/problems/find-the-duplicate-number/
 * nums可看成图的邻接表，因为有重复数字，有至少两条边指向同一个结点，一定存在环
 * 使用快慢指针确定相遇点，再将slow指针回到原点，fast,slow都每次跳一步，相遇点即为环的入口
 *@Author lyl
 *@Version 1.0
 */
public class _2_287 {
}
class Solution2 {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;
        while (fast == 0 || fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        slow = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }
}