package necessary.class059;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *ClassName: _3_minTopo
 *Package: necessary.class059
 *Description:创建于 2025/11/9 21:25
 *https://www.luogu.com.cn/problem/U107394
 *字典序最小的拓扑排序(小根堆)
 *@Author lyl
 *@Version 1.0
 */
public class _3_minTopo {
}

class Main{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int e=scanner.nextInt();
        int[][] edges=new int[e][2];
        for (int i = 0; i < e; i++) {
            edges[i][0]=scanner.nextInt();
            edges[i][1]=scanner.nextInt();
        }
        topoSort(n,edges);
        scanner.close();
    }

    private static void topoSort(int n,int[][] edges) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree=new int[n];
        for(int[] e:edges){
            graph.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }
        int[] queue=new int[n];
        int l=0,r=0;
        for (int i = 0; i < n; i++) {
            if(inDegree[i]==0){
                queue[r++]=i;
            }
        }
        ArrayList<Integer> tmp=new ArrayList<>();
        while(l<r || !tmp.isEmpty()){
            int node=queue[l++];
            for(int v:graph.get(node)){
                if(--inDegree[v]==0){
                    tmp.add(v);
                }
            }
            if(l==r){
                tmp.sort((a,b)->a-b);
                for (int i = 0; i < tmp.size(); i++) {
                    queue[r++]=tmp.get(i);
                }
                tmp.clear();
            }
        }
        for(int i=0;i<r;i++){
            System.out.print(queue[i]+" ");
        }
    }
}