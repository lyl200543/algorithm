package beginning;

/**
 *ClassName: beginning.class005
 *Package: PACKAGE_NAME
 *Description:创建于 2025/7/25 21:05
 * 对数器：用同一个样本数据（随机）分别测试暴力解和最优解
 * 根据测试结果是否相同来判断代码是否正确
 *@Author lyl
 *@Version 1.0
 */
public class class005_Validator {
    public static void main (String[] args) {
        int N = 5;
        int V = 10;
        int frequency = 50;
        System.out.println("测试开始");
        for (int i = 0 ; i < frequency ; i++) {
            int n = (int) (Math.random() * N) + 1;
            int[] arr = createArr(n , V);
            int[] arr1 = copyArr(arr);
            int[] arr2 = copyArr(arr);
            int[] arr3 = copyArr(arr);
            select(arr1);
            bubble(arr2);
            insert(arr3);
            //测试出错用例和具体哪个方法
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));
//            System.out.println(Arrays.toString(arr3));
            if (! sameArr(arr1 , arr2) || ! sameArr(arr1 , arr3))
                System.out.println("出错了");
        }
        System.out.println("测试结束");
    }

    public static boolean sameArr (int[] arr1 , int[] arr2) {
        int n = arr1.length;
        for (int i = 0 ; i < n ; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArr (int[] arr) {
        int n = arr.length;
        int[] newarr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            newarr[i] = arr[i];
        }
        return newarr;
    }

    public static int[] createArr (int n , int v) {
        int[] arr = new int[n];
        for (int i = 0 ; i < n ; i++) {
            int value = (int) (Math.random() * v) + 1;
            arr[i] = value;
        }
        return arr;
    }

    public static void swap (int[] arr , int x , int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

    public static void select (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        for (int i = 0 ; i < n - 1 ; i++) {
            int min = i;
            for (int j = i + 1 ; j < n ; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            swap(arr , i , min);
        }
    }

    public static void bubble (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        for (int i = n - 1 ; i > 0 ; i--) {
            for (int j = 0 ; j < i ; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr , j , j + 1);
            }
        }
    }

    public static void insert (int[] arr) {
        if (arr == null || arr.length < 2)
            return;
        int n = arr.length;
        for (int i = 1 ; i < n ; i++) {
            for (int j = i - 1 ; j >= 0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr , j , j + 1);
            }
        }
    }
}
