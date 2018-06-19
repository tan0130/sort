package sort;

/**
 * create by tan on 2018/6/19
 * 基本排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo6 {
    public static void main(String[] args) {
        int[] arr = {1, 34, 23, 34, 456, 4567};

        // 冒泡排序
        bubbleSort(arr);
        System.out.println();

        // 快速排序
        System.out.println("快速排序后的数组为：");
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
     * 实现方式：for循环遍历打印数组元素
     * @param arr 传入一个int类型的数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：for循环遍历数组，将前后两个元素依次比较，将较大的值往后靠
     * @param arr 传入一个int类型的数组
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
     * 实现方式：
     * 1.取中值：将数组两端的元素对应下标标记为i和j，取第一个数为基准值，先从j开始向左遍历，找到第一个小于基准值的元素，
     *          与基准值交换位置，在从i开始向右遍历，找到第一个大于基准值的元素，与基准值交换位置，直到i<=j,遍历结束
     * 2.快速排序：将基准值两边的数组进行排序
     * */
    /**
     * 取中值
     * @param low 传入一个int型的变量
     * @param high 传入一个int类型的变量
     * @param arr 传入一个int类型的数组
     * @return low 返回一个int类型的值
     * */
    private static int getMid(int low, int high, int[] arr) {
        int temp = arr[low]; // 取最左边的元素为基准值
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
     * @param low 传入一个int型的变量
     * @param high 传入一个int类型的变量
     * @param arr 传入一个int类型的数组
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
     * 实现方式：使用for循环遍历，将数组元素依次比较，将较小值的下标标记为min，每次将较小值排在靠前的位置
     * @param arr 传入一个int类型的数组
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
     * 实现方式：使用for循环遍历，定义一个currentElem，每次将需要遍历的元素插入已排序的数组
     * @param arr 传入一个int类型的数组
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > currentElem ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为：");
        printArr(arr);
    }
}
