package sort;

/**
 * create by tan on 2018/6/4
 * 排序算法实现
 * 1.冒泡排序
 * 2.快速排序
 * 3.选择排序
 * 4.插入排序
 **/
public class Sort_Demo4 {
    public static void main(String[] args) {
        int[] arr = {1, 23, 45, 1, 23, 345, 234, 23};

        // 冒泡排序
        bubbleSort(arr);
        System.out.println();

        // 快速排序
        System.out.println("快速排序后的数组为：");
        quickSort(0, arr.length - 1, arr);
        printArr(arr);
        System.out.println();

        // 选择排序
        selectSort(arr);
        System.out.println();

        // 插入排序
        insertSort(arr);
    }

    /**
     * 打印数组
     * 实现方式：for循环遍历数组
     * @param arr 接收一个int类型的数组
     * */
    private static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 冒泡排序
     * 实现方法：for循环遍历数组，依次将前后两个元素进行比较，将较大值往后靠
     * @param arr 接收一个int类型的数组
     * */
    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序后的数组为：");
        printArr(arr);
    }

    /**
     * 快速排序:对冒泡排序算法的优化
     * 1.取中值：将数组两边的元素下标分别标为i,j,每次取第一个值作为基准值，先从j开始从右向左查找到第一个小于基准值的
     * 值，然后与基准值互换位置，然后从i从左向右查找第一个大于基准值的值，然后与基准值交换位置，如此循环查找，直到i >=j
     * 时，第一次遍历查找结束，后续重复上述步骤
     * 2.将每次遍历查找的结果进行排序
     *
     * 1.取中值
     * @param low, high, arr 接收三个int类型的数据
     * @return low 返回比较得到的中值
     * */
    private static int getMid(int low, int high, int[] arr) {
        int temp = arr[low], temp1 = 0, temp2 = 0; // 每次取第一个值作为基准值
        while (low < high) {
            if (arr[high] >= temp) {
                high--;
            }
            temp1 = arr[low];
            arr[low] = arr[high];
            arr[high] = temp1;

            if (low < high && arr[low] <= temp) {
                low++;
            }
            temp2 = arr[high];
            arr[high] = arr[low];
            arr[low] = temp2;
        }
        return low;
    }

    /**
     * 2.快速排序
     * 实现方式：获得1步骤中获取的中值，然后将数组进行排序
     * @param low, high, arr 接收三个int类型的值
     * */
    private static void quickSort(int low, int high, int[] arr) {
        int mid = getMid(low, high, arr); // 获取步骤1取得的中值
        if (low < high) {
            quickSort(low, mid - 1, arr); // 将中值左边的数组进行排序
            if (mid != arr.length - 1) {
                quickSort(mid + 1, high, arr); // 将中值右边的数组进行排序
            }
        }
    }

    /**
     * 选择排序
     * 实现方式：for循环遍历数组,每次比较获取最小值并记录下标，每次比较完之后，如果最小下标和初始下标不一致，
     * 交换两个下标对应的值
     * @param arr 接收一个int类型的数组
     * */
    private static void selectSort(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
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
     * 实现方式：将数组分成小区间，for循环遍历数组，选取一个当前的数值为currentElem，每次需要插入的值与这个值作比较
     * 如果更大，交换位置
     * @param arr 接收一个int类型的数组
     * */
    private static void insertSort(int[] arr) {
        int currentElem = 0, j = 0;
        for (int i = 1; i < arr.length; i++) {
            currentElem = arr[i];
            for (j = i - 1; j >= 0 && arr[j] > currentElem ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentElem;
        }
        System.out.println("插入排序后的数组为：");
        printArr(arr);
    }
}
