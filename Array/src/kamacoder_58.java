import java.util.Scanner;

/**
 * ClassName: kamacoder_58
 * Package: PACKAGE_NAME
 * Description:创建于 2025/4/20 21:23
 *
 * @Author lyl
 * @Version 1.0
 */
public class kamacoder_58 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            arr[i] = scanner.nextInt();
        }
//        try {
//            while (true) {
//                int left = scanner.nextInt();
//                int right = scanner.nextInt();
//                int sum = 0;
//                for (int i = left ; i <= right ; i++) {
//                    sum += arr[i];
//                }
//                System.out.println(sum);
//            }
//        } catch (Exception e) {
//
//        } finally {
//            scanner.close();
//        }

        while (true) {
            int left = scanner.nextInt();
            int right = scanner.nextInt();
            int sum = 0;
            for (int i = left ; i <= right ; i++) {
                sum += arr[i];
            }
            System.out.println(sum);
        }

    }
}
