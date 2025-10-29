package necessary.class056;

import java.io.*;

/**
 *ClassName: _1_implement
 *Package: necessary.class056
 *Description:创建于 2025/10/29 21:23
 * 小挂大+扁平化（路径压缩）
 * https://www.nowcoder.com/practice/e7ed657974934a30b2010046536a5372
 *@Author lyl
 *@Version 1.0
 */
public class _1_implement {
}


//通过
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            Main main=new Main();
            int n = (int) in.nval;
            main.disjoinSet(n);
            in.nextToken();
            int m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                int op = (int) in.nval;
                in.nextToken();
                int x = (int) in.nval;
                in.nextToken();
                int y = (int) in.nval;
                if (op == 1) {
                    out.println(main.isSameSet(x, y) ? "Yes" : "No");
                } else {
                    main.union(x, y);
                }
            }
        }
        out.flush();
        out.close();
        br.close();
    }


    private int[] parent;
    private int[] size;
    private int[] stack;

    private void disjoinSet(int n) {
        parent = new int[n + 1];
        size = new int[n + 1];
        stack = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int v) {
        int size = 0;
        while (v != parent[v]) {
            stack[size++] = v;
            v = parent[v];
        }
        while (size > 0) {
            parent[stack[--size]] = v;
        }
        return v;
    }

    private boolean isSameSet(int a, int b) {
        return find(a) == find(b);
    }

    private void union(int a, int b) {
        int r1 = find(a);
        int r2 = find(b);
        if (r1 != r2) {
            if (size[r1] >= size[r2]) {
                parent[r2] = r1;
                size[r1] += size[r2];
            } else {
                parent[r1] = r2;
                size[r2] += size[r1];
            }
        }
    }
}

//不通过，超时，输入，输出耗时太长
//class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
//            int a = in.nextInt();
//            int b = in.nextInt();
//            Main main = new Main();
//            main.disjoinSet(a);
//            for (int i = 0; i < b; i++) {
//                int s = in.nextInt();
//                int v1 = in.nextInt();
//                int v2 = in.nextInt();
//                if (s == 1) {
//                    if (main.isSameSet(v1, v2)) {
//                        System.out.println("Yes");
//                    } else {
//                        System.out.println("No");
//                    }
//                } else {
//                    main.union(v1, v2);
//                }
//            }
//        }
//    }
//
//    private int[] parent;
//    private int[] size;
//    private int[] stack;
//
//    private void disjoinSet(int n) {
//        parent = new int[n + 1];
//        size = new int[n + 1];
//        stack = new int[n + 1];
//        for (int i = 1; i <= n; i++) {
//            parent[i] = i;
//            size[i] = 1;
//        }
//    }
//
//    private int find(int v) {
//        int size = 0;
//        while (v != parent[v]) {
//            stack[size++] = v;
//            v = parent[v];
//        }
//        while (size > 0) {
//            parent[stack[--size]] = v;
//        }
//        return v;
//    }
//
//    private boolean isSameSet(int a, int b) {
//        return find(a) == find(b);
//    }
//
//    private void union(int a, int b) {
//        int r1 = find(a);
//        int r2 = find(b);
//        if (r1 != r2) {
//            if (size[r1] >= size[r2]) {
//                parent[r2] = r1;
//                size[r1] += size[r2];
//            } else {
//                parent[r1] = r2;
//                size[r2] += size[r1];
//            }
//        }
//    }
//}














