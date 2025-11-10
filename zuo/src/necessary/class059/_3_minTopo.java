package necessary.class059;

import java.io.*;
import java.util.ArrayList;

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


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            int n = (int) in.nval;
            in.nextToken();
            int m = (int) in.nval;
            int[][] edges = new int[m][2];
            for (int i = 0, from, to; i < m; i++) {
                in.nextToken();
                from = (int) in.nval;
                in.nextToken();
                to = (int) in.nval;
                edges[i] = new int[]{from, to};
            }
            topoSort(n, edges);
        }
        out.flush();
        out.close();
        br.close();
    }

    private static void topoSort(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[n+1];
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            inDegree[e[1]]++;
        }
        //小根堆
        Heap heap = new Heap(n);
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                heap.add(i);
            }
        }
        int[] ans = new int[n];
        int count=0;
        while (heap.len != 0) {
            int x = heap.delete();
            ans[count++]=x;
            for(int neighbor:graph.get(x)){
                if(--inDegree[neighbor]==0){
                    heap.add(neighbor);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]+" ");
        }
    }

    private static class Heap {
        int[] arr;
        int len;

        Heap(int n) {
            arr = new int[n];
            len = 0;
        }

        void add(int x) {
            arr[len++] = x;
            int index = len - 1;
            while (index != 0 && arr[(index - 1) / 2] > arr[index]) {
                index = (index - 1) / 2;
            }
            arr[len - 1] = arr[index];
            arr[index] = x;
        }

        int delete() {
            int ans = arr[0];
            arr[0] = arr[--len];
            int parent = 0, leftchild, rightchild;
            int tmp = arr[parent];
            while (parent * 2 + 1 < len) {
                leftchild = parent * 2 + 1;
                rightchild = leftchild + 1;
                int smallchild = rightchild < len && arr[leftchild] > arr[rightchild] ? rightchild : leftchild;
                if (arr[smallchild] > arr[parent]) {
                    break;
                }
                arr[parent] = arr[smallchild];
                parent = smallchild;
            }
            arr[parent] = tmp;
            return ans;
        }
    }
}