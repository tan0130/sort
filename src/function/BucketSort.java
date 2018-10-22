package function;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/**
 * create by 1311230692@qq.com on 2018/10/22 13:31
 * 桶排序
 * 概念：每一个桶（bucket）代表一个区间范围
 * 1、创建桶
 *      桶个数：等于原始数列的元素个数，除了最后一个桶只包含最大值，其他桶的区间按比例确定
 *      区间跨度：（最大值 - 最小值）/（桶的数量 - 1）
 * 2、遍历原始数组，将元素对号入座放入各个桶中
 * 3、每个桶内部的元素分别排序
 * 4、遍历所有的桶，输出所有元素
 *
 * 场景：double 型数组
 **/
public class BucketSort {

    /**
     * 桶排序
     * @param arr 数组
     * */
    public static double[] bucketSort(double[] arr) {
        // 1、取最大值和最小值，并输出区间 d
        double max = arr[0];
        double min = arr[0];
        for (double i: arr) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        double d = max - min;

        // 2、初始化桶，每个桶里面有一个 LinkedList 链表
        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        // 3、遍历原始数组，将每个元素放入桶中
        for (int i = 0; i < arr.length; i++) {
            int num = (int)((arr[i] - min) * (bucketNum - 1) / d);
            bucketList.get(num).add(arr[i]);
        }

        // 4、对每个桶内进行排序
        for (int i = 0; i < bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        // 5、输出全部元素
        double[] sortedArr = new double[arr.length];
        int index = 0;
        for (LinkedList<Double> list: bucketList) {
            for (double element: list) {
                sortedArr[index] = element;
                index++;
            }
        }
        return sortedArr;
    }
}
