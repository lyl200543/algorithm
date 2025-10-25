package necessary.class038;

import java.util.*;

/**
 *ClassName: _2_90
 *Package: necessary.class038
 *Description:创建于 2025/10/23 21:40
 * https://leetcode.cn/problems/subsets-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _2_90 {
    public static void main (String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(solution2.subsetsWithDup(new int[]{1 , 2 , 2}));

    }
}


//剪枝：例如：2222 333
//没有按第一个2的有无，第二个2的有无...来分情况（2^4）
//而是按有几个2来分情况（4）
class Solution2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        subarray(nums,0,new int[nums.length],0,ans);
        return ans;
    }

    private void subarray (int[] nums , int start,int[] path,int size, List<List<Integer>> ans) {
        if(start >= nums.length){
            List<Integer> tmp=new ArrayList<>();
            for (int i = 0 ; i < size ; i++) {
                tmp.add(path[i]);
            }
            ans.add(tmp);
        }else {
            int val=nums[start];
            int end=start+1;
            while(end < nums.length && nums[end] == val){
                end+=1;
            }
            subarray(nums,end,path,size,ans);
            for (int i = 0 ; i < end - start ; i++) {
                path[size++]=val;
                subarray(nums,end,path,size,ans);
            }
        }
    }


    //效率极低
    //因为数组是可变的，所以每次都要复制一遍原数组，否则是对同一个地址上的值做改变
    //而字符串是不可变的
//    public List<List<Integer>> subsetsWithDup(int[] nums) {
//        if (nums.length == 0) {
//            List<List<Integer>> ans = new ArrayList<>();
//            ans.add(new ArrayList<>());
//            return ans;
//        }
//        List<List<Integer>> ans=new ArrayList<>();
//        Set<List<Integer>> set = new HashSet<>();
//        int[] subnums=new int[nums.length-1];
//        System.arraycopy(nums,1,subnums,0,subnums.length);
//        List<List<Integer>> lists = subsetsWithDup(subnums);
//        for (List<Integer> list:lists){
//            List<Integer> copy1=new ArrayList<>(list);
//            set.add(copy1);
//            List<Integer> copy2=new ArrayList<>(list);
//            copy2.add(nums[0]);
//            copy2.sort((a,b)->a-b);
//            set.add(copy2);
//        }
//        ans.addAll(set);
//        return ans;
//    }
}