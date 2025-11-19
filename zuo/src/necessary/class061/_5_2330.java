package necessary.class061;

import java.io.*;
import java.util.Arrays;

/**
 *ClassName: _5_2330
 *Package: necessary.class061
 *Description:创建于 2025/11/19 20:51
 * https://www.luogu.com.cn/problem/P2330
 * 最小生成树一定是最小瓶颈树
 * 最小瓶颈树：所有顶点连通的情况下，分值最大的边值尽可能小
 *@Author lyl
 *@Version 1.0
 */
public class _5_2330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in=new StreamTokenizer(br);
        PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
        while(in.nextToken()!=StreamTokenizer.TT_EOF){
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            int[][] edges=new int[m][3];
            for (int i = 0; i < m; i++) {
                in.nextToken();
                edges[i][0]=(int) in.nval;
                in.nextToken();
                edges[i][1]=(int)in.nval;
                in.nextToken();
                edges[i][2]=(int) in.nval;
            }
            Arrays.sort(edges,(a,b)->a[2]-b[2]);
            build(n);
            int ans=0;
            for (int i = 0; i < m; i++) {
               if(union(edges[i][0],edges[i][1])){
                   ans=edges[i][2];
               }
            }
            System.out.println((n-1)+" "+ans);
        }
        out.flush();
        out.close();
        br.close();
    }

    private static int[] parent;

    private static void build(int n){
        parent=new int[n+1];
        for (int i = 0; i <= n; i++) {
            parent[i]=i;
        }
    }

    private static int find(int x){
        if(x==parent[x]){
            return parent[x];
        }
        parent[x]=find(parent[x]);
        return parent[x] ;
    }

    private static boolean union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x!=y){
            parent[x]=y;
            return true;
        }
        return false;
    }
}
