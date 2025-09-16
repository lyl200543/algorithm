package necessary;

import java.io.*;
import java.util.Arrays;

/**
 *ClassName: class027_2_newcoder_lineCoincide
 *Package: necessary
 *Description:创建于 2025/9/16 18:31
 *线段最大重合问题
 *@Author lyl
 *@Version 1.0
 */
public class class027_2_newcoder_lineCoincide {
}

class Main {
    public static int n;
    public static int MAXN = 10001;
    public static int[][] arr = new int[MAXN][2];

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0 ; i < n ; i++) {
                in.nextToken();
                arr[i][0] = (int) in.nval;
                in.nextToken();
                arr[i][1] = (int) in.nval;
            }
            System.out.println(compute());

        }
        out.flush();
        out.close();
        br.close();
    }

    private static int compute () {
        int max = 0;
        Arrays.sort(arr , 0 , n , (a , b) -> a[0] - b[0]);
        for (int i = 0 ; i < n ; i++) {
            while (size > 0 && heap[0] <= arr[i][0]) {
                pop();
            }
            add(arr[i][1]);
            max = Math.max(max , size);
        }
        return max;
    }

    public static int[] heap = new int[MAXN];
    public static int size = 0;

    public static void swap (int a , int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }

    public static void add (int x) {
        heap[size]=x;
        int i = size++;
        while (i != 0 && heap[i] < heap[(i - 1) / 2]) {
            swap(i , (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public static void pop () {
        swap(0 , -- size);
        int i = 0;
        while (i * 2 + 1 < size) {
            int left = i * 2 + 1;
            int best = left + 1 < size && heap[left + 1] < heap[left] ? left + 1 : left;
            best = heap[best] < heap[i] ? best : i;
            if (best == i) {
                break;
            }
            swap(best , i);
            i = best;

        }
    }

}