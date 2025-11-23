package necessary.class050;

/**
 *ClassName: _1_922
 *Package: necessary.class050
 *Description:创建于 2025/11/23 21:36
 *  https://leetcode.cn/problems/sort-array-by-parity-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _1_922 {
}
class Solution1 {
    public int[] sortArrayByParityII(int[] nums) {
        int n = nums.length;
        for (int even = 0, odd = 1; even < n && odd < n;) {
            if ((nums[n - 1] & 1) == 1) {
                swap(nums, odd, n - 1);
                odd += 2;
            } else {
                swap(nums, even, n - 1);
                even += 2;
            }
        }
        return nums;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}

//class Solution1 {
//    public int[] sortArrayByParityII(int[] nums) {
//        int a=0,b=0;
//        while(a<nums.length){
//            b=a;
//            if(a%2==0){
//                while(nums[b]%2==1){
//                    b++;
//                }
//                swap(nums,a,b);
//            }else{
//                while(nums[b]%2==0){
//                    b++;
//                }
//                swap(nums,a,b);
//            }
//            a++;
//        }
//        return nums;
//    }
//
//    private void swap(int[] nums,int a,int b){
//        int tmp=nums[a];
//        nums[a]=nums[b];
//        nums[b]=tmp;
//    }
//}