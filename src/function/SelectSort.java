package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:16
 * 选择排序算法实现
 **/
public class SelectSort {
    /**
     * 选择排序
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，每次取出较小值，一次遍历结束之后，比较较小值的下标和 i 的值是否相等
     * ，若不相等，交换位置
     * @param arr 数组
     * */
    public static void selectSort(int[] arr) {
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
    }
}
