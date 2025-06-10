import java.util.Scanner;

/**
 *ClassName: kamacoder_54
 *Package: PACKAGE_NAME
 *Description:创建于 2025/6/10 20:51
 *@Author lyl
 *@Version 1.0
 */
public class kamacoder_54 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int count = 0;
        for (int i = 0 ; i < s.length() ; i++) {
            if (Character.isDigit(s.charAt(i)))
                count++;
        }
        char[] str = new char[s.length() + count * 5];
        int left = s.length() - 1;
        int right = str.length - 1;
        while (right >= 0) {
            if (Character.isDigit(s.charAt(left))) {
                str[right] = 'r';
                str[right - 1] = 'e';
                str[right - 2] = 'b';
                str[right - 3] = 'm';
                str[right - 4] = 'u';
                str[right - 5] = 'n';
                right -= 6;
                left--;
            } else {
                str[right] = s.charAt(left);
                left--;
                right--;
            }
        }
        System.out.println(str);
    }
}

