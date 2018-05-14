package sort;

/**
 * create by tan on 2018/5/14
 * 数组排序算法：
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo1 {
    public static void main(String[] args) {
        int[] arr = {1,23,231,1,34,56,345,34};

        // 冒泡排序
//        bubbleSort(arr);

        // 快速排序
        /*System.out.println("快速排序后的数组为：");
        quickSort(0, arr.length - 1, arr);
        printArr(arr);*/

        // 选择排序
//        selectSort(arr);
    }

    // 打印数组:遍历数组元素，然后输出控制台
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 冒泡排序:通过前后两个元素两两逐次比较，将较大值往后靠
    private static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
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
     * 1.取中值：第一次选取最左边的元素为中值，先从最右边元素开始，查找第一个小于中值的值，并与中值交换位置，然后再
     *          从左向右查找第一个大于中值的值，并与中值交换位置，直到low > high，第一次比较结束，之后再重复步骤
     * 2.快速排序实现：每次将中值前后部分的数组元素进行排序
     * */
    // 去中值
    private static int getMid(int low, int high, int[] arr) {
        int temp = arr[low];
        while(low < high) {
            if(low < high && arr[high] >= temp)
                high--;
            int temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp1;

            if(low < high && arr[low] <= temp)
                low++;
            int temp2 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp2;
        }
        return low;
    }
    // 快速排序
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMid(low, high, arr);
        if(low < high) {
            quickSort(low, mid - 1, arr);
            if(mid != arr.length - 1)
                quickSort(mid + 1, high, arr);
        }
    }

    // 选择排序:逐个比较元素，记录较小的那个值，比较结束后将较小值往前放
    private static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min])
                    min = j;
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("选择排序后的数组为：");
        printArr(arr);
    }

    // 插入排序：将数组分成一小段，然后后面的元素与currentElem元素比较，如果比currentElem元素大，就交换前后元素位置
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] >= currentElem; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
    }
}
