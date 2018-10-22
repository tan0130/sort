package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:20
 * 主函数
 **/
public class MainMethod {
    public static void main(String[] args) {
        int[] arr = {1, 23, 23, 345, 456, 23};
        double[] arr1 = {1.01, 23.02, 34.02, 1.01};
        // 原数组为
        System.out.println("未排序前数组为：");
        PrintArr.printArr(arr);
        System.out.println();

        // 冒泡排序
//        System.out.println("冒泡排序后的数组为：");
//        BubbleSort.bubbleSort(arr);
//        PrintArr.printArr(arr);

        // 快速排序
//        System.out.println("快速排序后的数组为：");
//        QuickSort.quickSort(0, arr.length - 1, arr);
//        PrintArr.printArr(arr);

        // 选择排序
//        System.out.println("选择排序后的数组为：");
//        SelectSort.selectSort(arr);
//        PrintArr.printArr(arr);

        // 插入排序
//        System.out.println("插入排序后的数组为：");
//        InsertSort.insertSort(arr);
//        PrintArr.printArr(arr);

        // 计数排序
//        System.out.println("计数排序后的数组为：");
//        CountSort.countSort(arr);
//        PrintArr.printArr(arr);

        // 桶排序
        System.out.println("桶排序之后的数组为：");
        double[] d = BucketSort.bucketSort(arr1);
        for (double i: d) {
            System.out.print(i + " ");
        }
    }
}
