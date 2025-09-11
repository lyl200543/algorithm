package necessary;

/**
 *ClassName: class022_2_leetcode_493
 *Package: beginning
 *Description:创建于 2025/9/9 19:57
 *@Author lyl
 *@Version 1.0
 */
public class class022_2_leetcode_493 {

}
class Solution2 {
    public static int MAXN=50001;
    public static int[] arr=new int[MAXN];
    public static int[] help=new int[MAXN];
    public static int n;

    public int reversePairs(int[] nums) {
        n=nums.length;
        for(int i=0 ;i<n ;i++){
            arr[i]=nums[i];
        }
        return count(0,n-1);
    }

    public static int count(int l,int r){
        if(l==r){
            return 0;
        }
        int m=(l+r)/2;
        return count(l,m)+count(m+1,r)+merge(l,m,r);
    }

    public static int merge(int l, int m, int r){
        int ans=0;
        for(int i=l,j=m+1;i<=m;i++){
            //切换为long类型，防止溢出
            while(j<=r && (long)arr[i] > (long) 2*arr[j]){
                j++;
            }
            ans+=j-m-1;
        }
        //归并排序
        int i = l;
        int a = l;
        int b = m + 1;
        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }
        while (a <= m) {
            help[i++] = arr[a++];
        }
        while (b <= r) {
            help[i++] = arr[b++];
        }
        for (int j = l; j <= r; j++) {
            arr[j] = help[j];
        }
        return ans;
    }
}