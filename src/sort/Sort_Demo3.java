package sort;

/**
 * create by tan on 2018/5/28
 * 基本排序算饭实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo3 {
    public static void main(String[] args) {
        int[] arr = {1,23,23,45,1,2345,23,56};

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
     * for循环遍历打印数组
     * @param arr
     * */
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现：将数组从左向右逐个遍历，将较大值往后放
     * */
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
     * 1.取中值：将数组最左边的元素标记为i，左右边的标记为j,选取最左边的元素为中值，从数组最右边的元素开始查找，找到
     * 第一个小于中值的数值，并交换位置，然后再从最左边开始查找第一个大于中值的数值，并交换位置，如此循环，直到i >= j时，一次遍历结束，
     * 后续重复步骤
     * 2.快速排序
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

    /**
     * 选择排序
     * 实现：for循环遍历数组，每次选取出最小值，并将下标标注为min，最后比较结束，将较小值往前放
     * */
    public static void selectSort(int[] arr) {
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

    /**
     * 插入排序
     * 实现：for循环遍历数组，选取一个数组空间，选取一个值为currentElem,将需要插入的值和currentElem值做比较
     * 若是大，则往后移一位
     * */
    public static void insertSort(int[] arr) {
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
