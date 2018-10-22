package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:15
 * 插入排序算法实现
 **/
public class InsertSort {
    /**
     * 插入排序
     * 实现方式：使用 for 循环遍历数组，每次将待排序的数组元素插入一排序的数组中
     * @param arr 数组
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
    }
}
