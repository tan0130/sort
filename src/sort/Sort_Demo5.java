package sort;

/**
 * create by tan on 2018/6/11
 * 基本排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo5 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 34, 23, 45, 34, 234, 456};

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
     * 打印数据
     * 实现：使用for循环遍历数组
     *
     * @param arr 接收一个arr的数组
     */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现：使用for循环遍历数组，然后将数组元素依次前后两两相比较，将较大的数值往后靠
     *
     * @param arr 接收一个arr的数组
     */
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
     * 取中值
     * 实现：基准值位置：将数组最左边和最右边元素的下标分别标为i,j,选取第一个元素为基准值，先从j开始查找第一个小于基准值的值，
     * 与基准值互换位置，再从i开始查找第一个大于基准值的值，与基准值互换位置，当遍历条件i <= j不满足时，第一次遍历结束，
     * 这样每次遍历都把数组分为左右两个数组，重复步骤
     *
     * @param low  接收一个low下标
     * @param high 接收一个high下标
     * @param arr  接收一个arr数组
     * @return low 返回基准值low
     */
    private static int getMid(int low, int high, int[] arr) {
        int temp = arr[low]; // 取基准值
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
     * 实现：将基准值左右两边的数组进行快速排序
     *
     * @param low  接收一个low下标
     * @param high 接收一个high下标
     * @param arr  接收一个arr数组
     */
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
     * 实现：使用for循环遍历数组，依次比较前后两个值,将较小值的下标标记为min,,遍历完数组之后，
     * 如果min的值和初始下标不一样，则对换两个下标的值
     *
     * @param arr 接收一个arr的数组
     */
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
     * 实现：定义一个currentElem，赋值为arr[i],将要插入的值和这个值做比较，若是大，则后移，这样每次比较完成之后，前面都是一个有序数组
     * @param arr 接收一个arr数组
     * */
   private static void insertSort(int[] arr) {
       int currentElem = 0, j;
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
