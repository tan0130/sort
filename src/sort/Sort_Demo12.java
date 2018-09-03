package sort;

/**
 * create by 1311230692@qq.com on 2018/9/3 08:40
 * 基本排序算法实现
 **/
public class Sort_Demo12 {
    public static void main(String[] args) {
        int[] arr = {1,23,23,34,23,1234,345};

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
     * 实现方式：使用 for 循环遍历数组，之后打印控制台
     * @param arr 传入 int 型的数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，将较大值上浮
     * @param arr 传入 int 型的数组
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
     * 1.取中值：使用 for 循环遍历数组，将数组两边元素的下标依次标为 i 和 j，取第一个元素的值为基准值，从 j 开始，从右向左遍历，直到找到第一个
     * 小于基准值的元素，与基准值交换位置；再从 i 开始从左向右遍历，直到找到第一个大于基准值的元素，与基准值交换位置，直到 i >= j,一次遍历结束
     * @param low
     * @param high
     * @param arr
     * @return low
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
     * 实现方式：
     * 2.快速排序：获取中值，进行快速排序
     * @param low 传入 int 型的下标
     * @param high 传入 int 型的下标
     * @param arr 传入 int 型的数组
     * */
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMid(low, high, arr);
        if (low < high) {
            quickSort(low, mid - 1,arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }

    /**
     * 选择排序
     * 实现方式;使用 for 循环遍历数组，新建遍历 min 用于存放两个元素中值较小的下标，依次循环之后，比较 min 和 i 的值是否相等，不相等，交换
     * 值位置
     * @param arr 传入 int 型数组
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
     * 实现方式：使用 for 循环遍历数组，将待排序的元素插入已排序的数组中
     * @param arr 传入 int 型的数组
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
