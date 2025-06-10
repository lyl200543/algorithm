import java.util.Scanner;

/**
 *ClassName: kamacoder_55
 *Package: PACKAGE_NAME
 *Description:创建于 2025/6/10 21:06
 *@Author lyl
 *@Version 1.0
 */

public class kamacoder_55 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String s = scanner.next();
//        String newstr = s.substring(s.length() - num , s.length()) + s.substring(0 , s.length() - num + 1);
//        System.out.println(newstr);


        //左/右旋转字符串：先旋转整体再旋转局部/先旋转局部再旋转整体
        char[] array = s.toCharArray();
        reverse(array,0,array.length-1);
        reverse(array,0,num-1);
        reverse(array,num,array.length-1);
        System.out.println(array);
    }

    public static void reverse (char[] array , int left , int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
}
