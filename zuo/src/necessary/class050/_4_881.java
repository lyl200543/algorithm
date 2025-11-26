package necessary.class050;

import java.util.Arrays;

/**
 *ClassName: _4_881
 *Package: necessary.class050
 *Description:创建于 2025/11/26 19:31
 *  https://leetcode.cn/problems/boats-to-save-people/
 *@Author lyl
 *@Version 1.0
 */
public class _4_881 {
}
class Solution4 {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l=0,r=people.length-1;
        int count=0;
        while(l<=r){
            if(people[l]+people[r]>limit){
                r--;
            }else{
                l++;
                r--;
            }
            count++;
        }
        return count;
    }
}
