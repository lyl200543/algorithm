package necessary.class038;

import java.util.Stack;

/**
 *ClassName: _7_TowerOfHanoi
 *Package: necessary.class038
 *Description:创建于 2025/10/28 21:05
 * //打印 n 层汉诺塔
 *@Author lyl
 *@Version 1.0
 */
public class _7_TowerOfHanoi {
    public static void main(String[] args) {
        printHanoi(4, "左", "右", "中");
    }

    public static void printHanoi(int i, String from, String to, String other) {
        if (i == 1) {
            System.out.println("第 1 个圆盘从 " + from + " 经过 " + other + " 到 " + to);
        } else {
            printHanoi(i - 1, from, other, to);
            System.out.println("第 " + i + " 个圆盘从 " + from + " 经过 " + other + " 到 " + to);
            printHanoi(i - 1, other, to, from);
        }
    }
}
