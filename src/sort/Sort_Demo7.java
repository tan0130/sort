package sort;

/**
 * create by tan on 2018/6/25
 * 排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo7 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 34, 23, 45, 36, 123};

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
     * 实现方式：使用for循环依次遍历打印数组元素
     * @param arr 传入一个int类型的数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用for循环遍历数组，将前后两个数组元素依次遍历比较，将较大值往后靠
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
     * 1.取中值：先定义数组两边的下标分别标为i,j,取最左边的值为基准值，然后从j开始向右遍历，找到第一个小于基准值的数值
     * 再与基准值交换位置，然后再从i开始向右遍历，寻找到第一个大于基准值的数值，交换位置，直到i >= j，第一次遍历结束，
     * 之后重复步骤
     * @param low 传入int类型的值
     * @param high 传入int类型的值
     * @param arr 传入一个int类型的数组
     * @return low 返回一个int类型的值
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
     * 2.快速排序
     * 实现方式：将每次遍历得到的中值前后两个数组进行快速排序
     * @param low 传入一个int类型的值
     * @param high 传入一个int类型的值
     * @param arr 传入一个int类型的值
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
     * 实现方式：使用for循环遍历，将数组元素依次比较，将较小值的小标标为min,每次遍历排序找出最小的值
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
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        System.out.println("选择排序后的数组为：");
        printArr(arr);
    }

    /**
     * 插入排序
     * 实现方式：使用for循环遍历，将数组依次划分成小区间，将小区间里面的元素进行排序
     * @param arr 传入一个int类型的数组
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > currentElem; j--) {
                arr[j + 1] = arr[j];
            }
            arr[ j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为：");
        printArr(arr);
    }
}
