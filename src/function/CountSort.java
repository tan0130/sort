package function;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:19
 * 计数排序算法实现
 **/
public class CountSort {
    /**
     * 计数排序：
     * 实现方式：
     * 1、对输入的数字进行频率统计
     * 2、将频率转换为开始索引
     * 准备三个数组：
     * 1、要排序的数列大小
     * 2、要记录比某个数小的元素的个数，大小为 K, 构造一个 k + 1 大小的数组
     * */
    public static void countSort(int[] arr) {
        int max = arr[0], min = arr[0];
        for (int i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        // 最大最小元素之间范围【min, max】的长度
        int r = max - min + 1;
        // 1、计算频率
        int[] count = new int[r + 1]; // 数组每一个下标位置的值，代表了对应整数出现的次数
        for (int i: arr) {
            // 使用加 1 后的索引，有重复值就自增
            count[i - min + 1]++;
        }
        // 2、频率 -> 元素的开始索引,后面的元素等于前面的元素之和
        for (int i = 0; i < r; i++) {
            count[i + 1] += count[i];
        }
        // 3、元素按照开始索引分类，用到一个和待排序数组一样大临时数组存放数据
        int[] aux = new int[arr.length];
        for (int i: arr) {
            // 填充一个数据后，自增，以便相同的数据可以填到下一个空位
            aux[count[i - min]++] = i;
        }
    }
}
