package sort;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * create by tan on 2018-05-09
 * 数组排序
 * */
public class Sort_Demo {
    public static void main(String[] args) {
        int[] arr = {1,23,23,45,45,23,456,34};

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("1", "李四");
        map.put("2", "李四");
        map.put("3", "李四");

        // 使用entrySet方式遍历HashMap
        /*Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Object> entry = (Map.Entry)iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
        }
        System.out.println();
        // 使用for循环遍历实现
        for (Map.Entry<String, Object> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }*/


        // 使用keySet方式遍历
        Iterator iter1 = map.keySet().iterator();
        while (iter1.hasNext()) {
            Object key1 = iter1.next();
            Object value1 = map.get(key1);
            System.out.println(key1 + ":" + value1);
        }
        System.out.println();
        // 使用for循环实现
        for (String key: map.keySet()) {
            System.out.println(key + ":" + map.get(key));
        }


        // 使用entrySet遍历Map
        /*Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry)iter.next();
            Object key = entry.getKey();
            Object value = entry.getValue();
            System.out.println(key + ":" + value);
        }*/

        // 冒泡排序
        /*bubbleSort(arr);
        System.out.println();*/

        // 快速排序
        /*System.out.println("快速排序后的数组为:");
        quickSort(0, arr.length - 1, arr);
        printArr(arr);
        System.out.println();*/

        // 选择排序
        /*selectSort(arr);
        System.out.println();*/

        // 插入排序
        // insertSort(arr);
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

    /**
     * 快速排序算法实现
     * 1.取中值
     * 2.快速排序算法实现
     * */
    public static int getMidValue(int low, int high, int[] arr) {
        int temp = arr[low]; // 取第一个值为中值
        while(low < high) {
            // 先从最左边寻找第一个比基准值小的值，之后进行交换
            if(low < high && arr[high] >= temp)
                high--;
            int temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            // 再从最右边查找第一个比基准值大的值，之后进行交换
            if(low < high && arr[low] <= temp)
                low++;
            int temp2 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp;
        }
        return low;
    }
    public static void quickSort(int low, int high, int[] arr) {
        int mid = getMidValue(low, high, arr);
        if(low < high) {
            quickSort(low, mid - 1, arr);
            if(mid != arr.length - 1)
                quickSort(mid + 1, high, arr);
        }
    }

    // 选择排序
    public static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length ; i++) {
            min = i;
            for (int j = min + 1; j < arr.length; j++) {
                if(arr[j] < arr[min]) {
                    min = j;
                }
            }
            if(min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
        System.out.println("选择排序后的数组为:");
        printArr(arr);
    }

    // 插入排序
    public static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > currentElem ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为:");
        printArr(arr);
    }
}
