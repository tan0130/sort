package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:09
 * 冒泡排序算法实现
 **/
public class BubbleSort {

    /**
     * 冒泡排序
     * 实现方式：使用 for 循环遍历数组，将数组前后两个元素依次比较，将较大值往后靠
     * @param arr 数组
     * */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
