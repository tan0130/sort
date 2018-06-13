package sort;

/**
 * create by tan on 2018/6/4
 * 交换两个数据的值
 * java三种方式：
 * 1.临时中间值
 * 2.做减法运算
 * 3.做异或运算
 **/
public class Swap {
    public static void main(String[] args) {
        /*int a = 2, b = 4;
        swap(a, b);*/
        System.out.println("结果为：" + testTry());
    }

    /**
     * 交换两个数字的值
     * 实现方式：
     * 1.新建临时变量
     * 2.做减法运算
     * 3.做异或运算
     * @param a, b 接收两个int类型的值
     * */
    private static void swap(int a, int b) {
        System.out.println("交换前的数值：a=" + a + "... b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("交换前的数值：a=" + a + "... b=" + b);
    }

    private static int testTry() {
        int x = 1;
        try {
            System.out.println("try里面的x:" + x);
            return x;
        } finally {
            System.out.println("进入finally块...");
            ++x;
            System.out.println("finally块的x为：" + x);
        }
    }
}
