package sort;

import java.util.Arrays;

/**
 * create by 1311230692@qq.com on 2018/10/22 08:49
 * 基本排序算法实现
 * 1、冒泡排序
 * 2、快速排序
 * 3、选择排序
 * 4、插入排序
 * 5、计数排序：
 * 计数排序是一种非常快捷的稳定性强的排序方法，时间复杂度O(n+k),其中n为要排序的数的个数，k为要排序的数的组大值。
 * 计数排序对一定量的整数排序时候的速度非常快，一般快于其他排序算法。但计数排序局限性比较大，只限于对整数进行排序。
 * 计数排序是消耗空间发杂度来获取快捷的排序方法，其空间发展度为O（K）同理K为要排序的最大值
 **/
public class Sort_Demo16 {
    public static void main(String[] args) {
        int[] arr = {12, 23, 134, 456, 23, 12};

        // 打印未排序前的数组
        System.out.println("未排序前数组为：");
        printArr(arr);
        System.out.println();

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
        System.out.println();

        // 计数排序
        countSort(arr);
    }

    /**
     * 打印数组
     * 实现方式：使用 for 循环遍历数组，然后打印控制台
     * @param arr 数组
     * */
    private static void printArr(int[] arr) {
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，将较大值往后靠
     * @param arr 数组
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
     * 实现方式：使用 for 循环遍历数组，将数组两边元素的下标依次标为 i 和 j,选取 arr[i] 为基准值，先从 j 开始从右向左遍历，找到第一个
     * 小于基准值的元素，并交换位置；再从 i 开始从坐向右遍历，找到第一个大于基准值的元素，并交换位置，遍历结束条件 i >= j
     * @param low 数组元素下标
     * @param high 数组元素下标
     * @param arr 数组
     * */
    private static int getMidValue(int low, int high, int[] arr) {
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
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMidValue(low, high, arr);
        if (low < high) {
            quickSort(low, mid -1, arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }

    /**
     * 选择排序
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，每次取出较小值，一次遍历结束之后，比较较小值的下标和 i 的值是否相等
     * ，若不相等，交换位置
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
     * 实现方式：使用 for 循环遍历数组，每次将待排序的数组元素插入一排序的数组中
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
     * 计数排序：
     * 实现方式：
     * 1、对输入的数字进行频率统计
     * 2、将频率转换为开始索引
     * 准备三个数组：
     * 1、要排序的数列大小
     * 2、要记录比某个数小的元素的个数，大小为 K, 构造一个 k + 1 大小的数组
     * */
    private static void countSort(int[] arr) {
       int max = arr[0], min = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        // 最大最小元素之间范围【min, max】的长度
        int r = max - min + 1;
        // 1、计算频率
        int[] count = new int[r + 1];
        for (int i: arr) {
            // 使用加 1 后的索引，有重复值就自增
            count[i - min + 1]++;
        }
        // 2、频率 -> 元素的开始索引
        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i];
        }
        // 3、元素按照开始索引分类，用到一个和待排序数组一样大临时数组存放数据
        int[] aux = new int[arr.length];
        for (int i: arr) {
            // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
            aux[count[i - min]++] = i;
        }

        System.out.println("计数排序后的数组为：");
        printArr(aux);
    }
}
