package sort;

/**
 * create by tan on 2018/7/2
 * 基本排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo8 {
    public static void main(String[] args) {
        int[] arr = {2, 12, 34, 23, 23, 456};

        // 冒泡排序
        bubbleSort(arr);
        System.out.println();

        // 快速排序
        System.out.println("冒泡排序后的数组为：");
        quickSort(0, arr.length - 1, arr);
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
     * 实现方式：使用 for 循环遍历数组，将值打印
     * @param arr 传入一个 int 型的数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环遍历数组，将数组元素依次逐个比较，将较大值往后靠
     * @param arr 传入一个 int 型的数组
     * */
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
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
     * 1.取中值：取最左边的元素为基准值，最左和最右两边的元素下标范别标为 i, j，先从 j 开始向左开始遍历，找到第一个小于
     * 基准值的元素，然后与基准值互换位置，然后再从 i 开始向右遍历，找到第一个大于 基准值的元素，然后互换位置，
     * 直到 i >= j，第一次遍历结束
     * @param low 传入一个 int 型的值
     * @param high 传入一个 int 型的值
     * @param arr 传入一个 int 型的数组
     * @return low 返回基准值
     * */
    private static int getMid(int low, int high, int[] arr) {
        int temp = arr[low];
        while (low < high) {
            if (arr[high] >= temp) {
                high--;
            }
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

    /**
     * 快速排序
     * 2.快速排序，每次遍历结束后将基准值左右两边的元素进行排序
     * @param low 传入一个 int 型的值
     * @param high 传入一个 int 型的值
     * @param arr 传入一个 int 型的数组
     * */
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMid(low, high, arr);
        if (low < high) {
            quickSort(low, mid - 1, arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }

    /**
     * 选择排序
     * 实现方式：让最小值的下标标为 min,使用 for 循环遍历数组，两两比较取出较小值
     * @param arr 传入一个 int 型的数组
     * */
    private static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
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
     * 实现方式：使用 for 循环遍历数组，定义一个 currentElem，每次将需要插入数组的元素与 currentElem 比较，
     * 若是较大，则将插入的值赋为 currentElem
     * @param arr 传入一个 int 型的参数
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > currentElem; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为：");
        printArr(arr);
    }
}
