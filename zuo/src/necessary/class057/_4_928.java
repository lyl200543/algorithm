package necessary.class057;

import java.util.Arrays;

/**
 *ClassName: _4_928
 *Package: necessary.class057
 *Description:创建于 2025/11/4 20:42
 * https://leetcode.cn/problems/minimize-malware-spread-ii/
 *@Author lyl
 *@Version 1.0
 */
public class _4_928 {
}
class Solution4 {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n=graph.length;
        build(n,initial);
        //将普通结点合并
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j && graph[i][j]==1 && !virus[i] && !virus[j]){
                    union(i,j);
                }
            }
        }
        //连接源头
        for(int sick:initial){
            for (int i = 0; i < n; i++) {
                if(sick!=i && graph[sick][i]==1 && !virus[i]){
                    int set = find(i);
                    if(source[set]==-1){
                        source[set]=sick;
//                        cnt[sick]+=size[set];
                    } else if (source[set] >= 0 && sick != source[set]) {
                        source[set]=-2;
                    }
                }
            }
        }
        //找删除结点
        for (int i = 0; i < n; i++) {
            if(source[i]>=0){
                cnt[source[i]]+=size[i];
            }
        }
        Arrays.sort(initial);
        int max=cnt[initial[0]];
        int index=initial[0];
        for (int i = 1; i < initial.length; i++) {
            if(cnt[initial[i]]>max){
                max=cnt[initial[i]];
                index=initial[i];
            }
        }
        return index;
    }

    private int[] parent;
    private boolean[] virus;
    private int[] size;
    //-1代表没有源头，>=0表示源头的下标，-2表示多个源头（删去一个结点无法使与之相连的结点不被污染）
    private int[] source;
    private int[] cnt;

    private void build(int n,int[] initial){
        parent=new int[n];
        virus=new boolean[n];
        size=new int[n];
        source=new int[n];
        cnt=new int[n];
        for (int i = 0; i < n; i++) {
            cnt[i]=0;
            source[i]=-1;
            size[i]=1;
            virus[i]=false;
            parent[i]=i;
        }
        for(int x:initial){
            virus[x]=true;
        }
    }

    private int find(int x){
        if(x==parent[x])
            return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }

    private void union(int a,int b){
        int x=find(a);
        int y=find(b);
        if(x!=y){
            parent[x]=y;
            size[y]+=size[x];
        }
    }
}