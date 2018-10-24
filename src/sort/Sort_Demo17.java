package sort;

/**
 * create by 1311230692@qq.com on 2018/10/24 14:12
 * 基本排序算法实现
 * 1、冒泡排序
 * 2、快速排序
 * 3、选择排序
 * 4、插入排序
 * 5、计数排序
 * 6、桶排序
 **/
public class Sort_Demo17 {

    /**
     * 主函数
     * */
    public static void main(String[] args) {
        int[] arr = {1, 23, 34, 23, 345, 1, 234};
        System.out.println("未排序前数组为：");
        printArr(arr);
        System.out.println();

        // 冒泡排序
//        bubblSort(arr);

        // 快速排序
//        System.out.println("快速排序后的数组为：");
//        quickSort(0, arr.length - 1, arr);
//        printArr(arr);

        // 选择排序
//        selectSort(arr);

        // 插入排序
//        insertSort(arr);

        // 计数排序
        countSort(arr);
    }

    /**
     * 打印数组
     * @param arr 数组
     * */
    private static void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     * @param arr 数组
     * */
    private static void bubblSort(int[] arr) {
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
     * 实现方式：使用 for 循环遍历数组，将数组两边元素的下标标为 i 和 j, 取左边第一个元素为基准值，先从 j 开始
     * 从右向左遍历，找到第一个小于基准值的元素，并与基准值交换位置；再从 i 开始从左向右遍历，找到第一个大于基准值
     * 的元素，并与基准值交换位置，直到 i >= j 时，一次遍历结束
     * @param low 数组下标
     * @param high 数组下标
     * @param arr 数组
     * */
    private static int getMidValue(int low, int high, int[] arr) {
        int temp = arr[low];
        while (low < high) {
            if (arr[high] >= arr[low]) {
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
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMidValue(low, high, arr);
        if (low < high) {
            quickSort(low, mid - 1, arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }

    /**
     * 选择排序
     * 实现方式：将数组前后两个元素一次比较，每次取出较小的元素再与后面的元素进行比较，一次遍历之后，比较较小值的下标
     * 是否和 i 相等，不相等交换元素位置
     * @param arr 数组
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
     * 实现方式：每次将待排序的数组插入到已排序的数组中
     * @param arr 数组
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

    /**
     * 计数排序
     * 实现方式：非基于比较，统计每个元素出现的频率放入对应的数组中，最后遍历数组下标获取所有元素
     * @param arr 数组
     * */
    private static void countSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }

        // 新建数组的长度 d
        int d = max - min + 1;
        int[] newArr = new int[d + 1];

        // 有重复自增
        for (int i: arr) {
            newArr[i - min + 1]++;
        }

        for (int i = 0; i < d; i++) {
            newArr[i + 1] += newArr[i];
        }

        // 新增一个长度和原数组一样大的数组来存放元素
        int[] aux = new int[arr.length];
        for (int i = 0; i < aux.length; i++) {
            aux[newArr[arr[i] - min]++] = arr[i];
        }
        System.out.println("计数排序后的数组为：");
        printArr(aux);
    }
}
