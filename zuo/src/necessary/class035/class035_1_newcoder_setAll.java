package necessary.class035;

import java.util.HashMap;
import java.util.Scanner;

/**
 *ClassName: class035_1_newcoder_setAll
 *Package: necessary.class035
 *Description:创建于 2025/10/3 21:02
 * https://www.nowcoder.com/practice/7c4559f138e74ceb9ba57d76fd169967
 *@Author lyl
 *@Version 1.0
 */
public class class035_1_newcoder_setAll {
}
class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        while (in.hasNextInt()) {
            int num = in.nextInt();
            if (num == 1) {
                put(in.nextInt(), in.nextInt());

            } else if (num == 2) {
                System.out.println(get(in.nextInt()));
            } else {
                setAll(in.nextInt());
            }
        }
    }

    public static HashMap<Integer, int[]> hashMap = new HashMap<>();
    public static int cnt = 0, setTime, setValue;

    public static void put(int k, int v) {
        if (hashMap.containsKey(k)) {
            int[] value = hashMap.get(k);
            value[0] = v;
            value[1] = cnt++;
        } else {
            hashMap.put(k, new int[] {v, cnt++});
        }
    }

    public static void setAll(int v) {
        setTime = cnt++;
        setValue = v;
    }

    public static int get(int k) {
        if (hashMap.containsKey(k)) {
            return hashMap.get(k)[1] < setTime ? setValue : hashMap.get(k)[0];
        } else {
            return -1;
        }
    }
}