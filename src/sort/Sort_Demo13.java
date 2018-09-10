package sort;

/**
 * create by 1311230692@qq.com on 2018/9/10 08:43
 * 基本排序算法实现
 **/
public class Sort_Demo13 {
    public static void main(String[] args) {
        int[] arr = {1,23,23,34,34,23,23,234,2345};
        System.out.println("原数组为：");
        printArr(arr);
        System.out.println();

        // 冒泡排序
        bubbleSort(arr);
        System.out.println();

        // 快速排序
        System.out.println("快速排序后的数组为：");
        quickSort(0,arr.length - 1, arr);
        printArr(arr);
        System.out.println();

        // 选择排序
        selectSort(arr);
        System.out.println();

        // 插入排序
        insertSort(arr);
    }

    /**
     * 打印数组
     * @param arr 传入 int 型数组
     * 实现方式：使用 for 循环遍历数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环依次遍历数组元素，将较大值往后靠
     * @param arr 传入 int 型数组
     * */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
//                    System.out.println();
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为：");
        printArr(arr);
    }

    /**
     * 快速排序
     * @param low 数组元素下标
     * @param high 数组元素下标
     * @param arr 传入 int 型数组
     * */
    private static int geMid(int low, int high, int[] arr) {
        int temp = arr[low];
        while (low < high) {
            if (arr[high] >= temp) {
                high--;
            }
//            System.out.println();
            int temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp1;

            if (low < high && arr[low] <= temp) {
                low++;
            }
            int temp2 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp2;
        }
        return low;
    }
    private static void quickSort(int low, int high, int[] arr) {
        int mid = geMid(low, high, arr);
        if (low < high) {
            quickSort(0, mid - 1, arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }

    /**
     * 选择排序
     * @param arr 传入 int 型的数组
     * */
    private static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = min + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("选择排序后的数组为：");
        printArr(arr);
    }

    /**
     * 插入排序
     * @param arr 传入 int 型的数组
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] >= currentElem; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为：");
        printArr(arr);
    }
}
