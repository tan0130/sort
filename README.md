# sortdemo<br>
|Author|tan0130|
|------|-------|
|email|1311230692@qq.com|
---
java实现简单的排序算法
=
# 一、冒泡排序
>算法实现：遍历数组，将数组前后两个值进行比较，将较大值往后靠<br>
>代码实现：<br>
```java
public static void bubbleSort(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if(arr[j] > arr[j + 1]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    System.out.println("冒泡排序后的数组为：");
    printArr(arr);
}
```
# 二、快速排序
>算法实现：1.取中值：一般选取数组第一个元素为中值，最左边值的下标为low,最右边的值下标为high,然后从数组最右边开始，查找第一个大于中值的数值，然后与中值交换位置,然后再从数组左边开始查找第一个大于中值
的数值，然后与中值交换位置，如痴循环下去，当low >= high时第一次遍历结束。<br>
>代码实现：<br>
```java
// 1.取中值
public static int getMid(int low, int high, int[] arr) {
    int temp = arr[low];
    while(low < high) {
        if(arr[high] >= temp)
            high--;
        int temp1 = arr[low];
        arr[low] = arr[high];
        arr[high] = temp1;

        if(low < high && arr[low] <= temp)
            low++;
        int temp2 = arr[high];
        arr[high] = arr[low];
        arr[low] = temp2;
    }
    return low;
}
// 2.将数组排序
public static void quickSort(int low, int high, int[] arr) {
    int mid = getMid(low, high, arr);
    if(low < high) {
        quickSort(low, mid - 1, arr);
        if(mid != arr.length - 1)
            quickSort(mid + 1, high, arr);
    }
}
```
# 三、选择排序
>算法实现：遍历数组，嵌套for循环，定义一个最小值下标min,每次遍历min = i,遍历的数值与arr[min]的值作比较，当更小时，将此时的下标赋值给min,
一次遍历完数组，当min != i时。交换两个值，这样每次遍历结束，最小值往前靠<br>
>代码实现：
```java
public static void selectSort(int[] arr) {
    int min = 0;
    for (int i = 0; i < arr.length; i++) {
        min = i;
        for (int j = i + 1; j < arr.length; j++) {
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
    System.out.println("选择排序后的数组为：");
    printArr(arr);
}
```
# 四、插入排序
>算法实现：先选取第一个元素，默认已排序，选取下一个元素，在已排序的元素中从后向前扫描，如果已排序的元素大于要插入的新元素，将该
元素移到下一位置，直到找到已排序的元素小于或等于要插入元素的位置，将新元素插入到下一位置中<br>
>代码实现：
```java
public static void insertSort(int[] arr) {
    int currentElem = 0, j = 0;
    for (int i = 1; i < arr.length; i++) {
        currentElem = arr[i];
        for (j = i - 1; j >= 0 && arr[j] >= currentElem; j--) {
            arr[j + 1] = arr[j];
        }
        arr[j + 1] = currentElem;
    }
    System.out.println("插入排序后的数组为：");
    printArr(arr);
}
```





