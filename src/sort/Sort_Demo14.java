package sort;

/**
 * create by 1311230692@qq.com on 2018/9/27 13:43
 * 基本排序算法实现：
 * 1、冒泡排序
 * 2、快速排序
 * 3、选择排序
 * 4、插入排序
 **/
public class Sort_Demo14 {
    public static void main(String[] args) {
        int[] arr = {1,23,23,456,23,1,2345};
    }

    /**
     * 打印数组
     * 实现方式：使用 for 循环遍历数组，将数组元素打印控制台
     * @param arr 传入 int 型数组作为参数
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环遍历数组，将数组前后元素两两一次比较，将较大值往后靠
     * @param arr 传入 int 型数组作为参数
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
     * 实现方式：使用 for 循环遍历数组，将数组两边的元素下标依次标为 i 和 j，取 arr[i] 为基准值，从 j 开始从右向左遍历，知道找到第一个小于
     * 基准值的元素，并交换位置，再从 i 开始从左向右遍历，直到找到大于基准值的元素，并交换位置，重复步骤，直到 i>= j,一次遍历结束
     * @param low 传入 int 型下标
     * @param high 传入 int 型下标
     * @param arr 传入 int 型数组
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
}
