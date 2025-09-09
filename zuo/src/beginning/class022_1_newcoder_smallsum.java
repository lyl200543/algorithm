package beginning;

import java.io.*;

/**
 *ClassName: class022_1_newcoder_smallsum
 *Package: beginning
 *Description:创建于 2025/9/9 19:09
 *@Author lyl
 *@Version 1.0
 */
public class class022_1_newcoder_smallsum {
    public static int MAXN=100001;
    public static int[] arr=new int[MAXN];
    public static int[] help=new int[MAXN];
    public static int n;

    public static void main (String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            n= (int) in.nval;
            for (int i = 0 ; i < n ; i++) {
                in.nextToken();
                arr[i]= (int) in.nval;
            }
            out.println(smallSum(0,n-1));
        }
        out.flush();
        out.close();
    }

    private static long smallSum (int l , int r) {
        if(r==l)
            return 0;
        int m=( r+l ) / 2;
        return smallSum(l,m) + smallSum(m+1,r) + merge(l,m,r);
    }

    private static long merge (int l , int m , int r) {
        long ans=0;
        for(int i=l,j=m+1,sum=0;j<=r;j++){
            while(i<=m && arr[i]<=arr[j]){
                sum+=arr[i++];
            }
            ans+=sum;
        }
        //归并排序：
        int a=l,b=m+1,i=l;
        while(a<=m && b<=r){
            help[i++]=arr[a]<=arr[b]?arr[a++]:arr[b++];
        }
        while (a<=m){
            help[i++]=arr[a++];
        }
        while (b<=r){
            help[i++]=arr[b++];
        }
        //注意范围：
//        for (int j = 0 ; j < n ; j++) {
//            arr[j]=help[j];
//        }
        for (int j = l ; j <= r  ; j++) {
            arr[j]=help[j];
        }
        return ans ;
    }
}
