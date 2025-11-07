package necessary.class059;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *ClassName: _1_createGraph
 *Package: necessary.class059
 *Description:创建于 2025/11/7 20:55
 *建图：有向/无向 有权/无权 （以有权为例,下标从1开始）
 *1）邻接矩阵
 *2）邻接表
 *3）链式前向星（数组确定，占空间少）：前插法+数组中的跳转
 *@Author lyl
 *@Version 1.0
 */
public class _1_createGraph {
    public static void main(String[] args) {
        // 理解了带权图的建立过程，也就理解了不带权图
        // 点的编号为1...n
        // 例子1自己画一下图，有向带权图，然后打印结果
        //        MatrixGrap graph = new MatrixGrap();
        //        LinkGraph graph = new LinkGraph();
        ForwardGraph graph = new ForwardGraph();
        int n1 = 4;
        int[][] edges1 = {{1, 3, 6}, {4, 3, 4}, {2, 4, 2}, {1, 2, 7}, {2, 3, 5}, {3, 1, 1}};
        graph.build(n1);
        graph.directGraph(edges1);
        graph.traversal(n1);
        System.out.println("==============================");
//         例子2自己画一下图，无向带权图，然后打印结果
                int n2 = 5;
                int[][] edges2 = {{3, 5, 4}, {4, 1, 1}, {3, 4, 2}, {5, 2, 4}, {2, 3, 7}, {1, 5, 5}, {4, 2, 6}};
                graph.build(n2);
                graph.undirectGraph(edges2);
                graph.traversal(n2);
    }
}

//1.邻接矩阵：
class MatrixGrap {

    private int[][] graph;

    public void build(int n) {
        graph = new int[n + 1][n + 1];
    }

    public void directGraph(int[][] edges) {
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
        }
    }

    public void traversal(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (graph[i][j] > 0) {
                    System.out.println(i + "到" + j + "，权值为" + graph[i][j]);
                }
            }
        }
    }

    public void undirectGraph(int[][] edges) {
        for (int[] e : edges) {
            graph[e[0]][e[1]] = e[2];
            graph[e[1]][e[0]] = e[2];
        }
    }
}


//2.邻接表：
class LinkGraph {
    List<List<int[]>> graph;

    public void build(int n) {
        graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public void directGraph(int[][] edges) {
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
        }
    }

    public void traversal(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < graph.get(i).size(); j++) {
                int[] edge = graph.get(i).get(j);
                System.out.println(i + "到" + edge[0] + ",权值为" + edge[1]);
            }
        }
    }

    public void undirectGraph(int[][] edges) {
        for (int[] e : edges) {
            graph.get(e[0]).add(new int[]{e[1], e[2]});
            graph.get(e[1]).add(new int[]{e[0], e[2]});
        }
    }
}


//3.链式前向星：
class ForwardGraph {
    private int m = 14;  //边数
    private int cnt; //第几条边
    private int[] head;  //结点对应的第一条边
    private int[] next = new int[m + 1];  //边对应的下一条边
    private int[] to = new int[m + 1];  //边对应的结点
    private int[] weight = new int[m + 1];  //边对应的权值

    public void build(int n) {
        cnt = 1;
        head = new int[n + 1];
    }

    public void directGraph(int[][] edges) {
        for (int[] e : edges) {
            addEdge(e[0], e[1], e[2]);
        }
    }

    private void addEdge(int f, int t, int w) {
        next[cnt] = head[f];
        to[cnt] = t;
        weight[cnt] = w;
        head[f] = cnt++;
    }

    public void traversal(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = head[i]; j > 0; j = next[j]) {
                System.out.println(i + "到" + to[j] + "，权值为" + weight[j]);
            }
        }
    }

    public void undirectGraph(int[][] edges) {
        for (int[] e : edges) {
            addEdge(e[0], e[1], e[2]);
            addEdge(e[1], e[0], e[2]);
        }
    }
}