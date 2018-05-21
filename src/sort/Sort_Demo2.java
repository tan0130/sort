package sort;

/**
 * create by tan on 2018/5/21
 * 四中基本排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo2 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 12, 23, 1,456, 345, 45, 23};

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

    // 遍历打印数组
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 冒泡排序:将前后两个元素逐个比较，将较大值往后靠
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为：");
        printArr(arr);
    }

    /**
     * 快速排序
     * 1.选取中值，将数组分割成前后两部分
     * 2.快速排序实现：先从中值最左边开始找到第一个小于中值的数值，与中值交换位置，然后再从最右边开始选取第一个大于
     * 中值的数，然后交换位置，直到i >= j 时，一趟排序结束
     *
     * */
    public static int getMid(int low, int high, int[] arr) {
        int temp = arr[low];
        while(low < high) {
            if(arr[high] >= temp)
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
    public static void quickSort(int low, int high, int[] arr) {
        int mid = getMid(low, high, arr);
        if(low < high) {
            quickSort(low, mid - 1, arr);
            if(mid != arr.length - 1)
                quickSort(mid + 1, high, arr);
        }
    }

    // 选择排序：每次比较选取较小值，将较小值放在数组前面
    public static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
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

    // 插入排序：数组从左向右选取小区间，将后面的元素插入到小区间，再将小区间的数值进行排序
    public static void insertSort(int[] arr) {
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
