package sort;
/**
 * create by tan on 2018-05-09
 * 数组排序
 * */
public class Sort_Demo {
    public static void main(String[] args) {
        int[] arr = {1,23,23,45,45,23,456,34};

        // 冒泡排序
        bubbleSort(arr);
    }

    // 打印数组
    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为:");
        printArr(arr);
    }
}
