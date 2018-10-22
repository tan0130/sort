package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:14
 * 快速排序算法实现
 **/
public class QuickSort {
    /**
     * 快速排序
     * 实现方式：使用 for 循环遍历数组，将数组两边元素的下标依次标为 i 和 j,选取 arr[i] 为基准值，先从 j 开始从右向左遍历，找到第一个
     * 小于基准值的元素，并交换位置；再从 i 开始从坐向右遍历，找到第一个大于基准值的元素，并交换位置，遍历结束条件 i >= j
     * @param low 数组元素下标
     * @param high 数组元素下标
     * @param arr 数组
     * */
    public static int getMidValue(int low, int high, int[] arr) {
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
    public static void quickSort(int low, int high, int[] arr) {
        int mid = getMidValue(low, high, arr);
        if (low < high) {
            quickSort(low, mid -1, arr);
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr);
            }
        }
    }
}
