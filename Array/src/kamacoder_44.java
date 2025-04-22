import java.util.Scanner;

/**
 * ClassName: kamacoder_44
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/22 20:51
 *
 * @Author lyl
 * @Version 1.0
 */
public class kamacoder_44 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];
        int[] area = new int[n + m - 2];
        int sum = 0;
        for (int i = 0 ; i < n ; i++) {
            for (int j = 0 ; j < m ; j++) {
                arr[i][j] = scanner.nextInt();
                if (i < n - 1)
                    area[i] += arr[i][j];
                if (j < m - 1)
                    area[n + j - 1] += arr[i][j];
                sum += arr[i][j];
            }
        }
        int count = n + m - 2;
        int min = sum;
        for (int i = 0 ; i < count ; i++) {
            int diff = 0;
            if (diff < min)
                min = diff;
        }
        scanner.close();
        System.out.println(min);
    }
}
