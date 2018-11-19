package sort;

/**
 * create by 1311230692@qq.com on 2018/11/19 9:15
 * 基本排序算法实现
 * 1、冒泡排序
 * 2、快速排序
 * 3、选择排序
 * 4、插入排序
 * 5、计数排序
 **/
public class Sort_Demo18 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 45, 23, 45, 123, 234, 1};

        System.out.println("原数组为：");
        printArr(arr);
        System.out.println();

        // 1、冒泡排序
//        bubbleSort(arr);

        // 2、快速排序
//        System.out.println("冒泡排序后的数组为：");
//        quickSort(0, arr.length - 1, arr);
//        printArr(arr);

        // 3、选择排序
//        selectSort(arr);

        // 4、插入排序
//        insertSort(arr);

        // 5、计数排序
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
     * 实现方式：使用 for 循环遍历数组，将较大值往后靠
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
     * 实现方式：使用 for 循环遍历数组，数组两边的下标分别标为 i 和 j，选取最左边的元素为基准值，先从数组右边从右向左遍历，找到第一个小于基准值的元素，并交换位置
     * ，再从左向右遍历，找到第一个大于基准值的元素，并与基准值交换位置，重复上述步骤，直到 i >= j 时，一次遍历结束
     * @param low 数组下标
     * @param high 数组下标
     * @param arr 数组
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
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，每次取出较小值，一次遍历结束之后，比较最小值的
     * 下标和第一个遍历的值得下标是否相等，不相等，交换位置
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
     * 实现方式：使用 for 循环遍历数组，将待排序的元素插入已排序的数组中
     * @param arr 数组
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 0; i < arr.length; i++) {
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
     * 实现方式：先取出最大值最小值、新建两个数组，依次遍历数组元素，记录数组元素对应出现的次数在新建数组中
     * @param arr 数组
     * */
    private static void countSort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int r = max - min + 1;
        int[] count = new int[r + 1];
        for (int j: arr) {
            count[j - min + 1]++; // 减去最小值
        }
        // 计算频率
        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i];
        }
        // 新建数组
        int[] aux = new int[arr.length];
        for (int i: arr) {
            aux[count[i - min]++] = i;
        }
        System.out.println("计数排序后的数组为：");
        printArr(aux);
    }

}
