package test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * create by 1311230692@qq.com on 2018/11/1 9:04
 **/
public class Test {
    public static void main(String[] args) {
//        getNextDay();
//        System.out.println();
//        getNextDay1();
//        test();

        Date date = new Date();
        System.out.println("当前毫秒时间戳：" + date.getTime());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("当前时间为：" + sdf.format(date.getTime()));

//        System.out.println("11:" + new Date().toString());

        // 获取上一月的第一天
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置当前日期为本月的第一天
        String firstDay = sdf.format(calendar.getTime());
        System.out.println("上一月第一天为：" + firstDay);

        // 获取上一月的最后一天
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.DAY_OF_MONTH, 0); // 设置为 1 号，当前日期为本月的第一天
        String lastDay = sdf.format(calendar1.getTime());
        System.out.println("上一月的最后一天为：" + lastDay);

        // 获取当前月第一天
        Calendar calendar2 = Calendar.getInstance();
        calendar2.add(Calendar.MONTH, 0);
        calendar2.set(Calendar.DAY_OF_MONTH, 1); // 设置为1号，当前日即为本月第一天
        String first = sdf.format(calendar2.getTime());
        System.out.println("当前月第一天为：" + first);

        // 获取当前月最后一天
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.DAY_OF_MONTH, calendar3.getActualMaximum(Calendar.DAY_OF_MONTH));
        String last = sdf.format(calendar3.getTime());
        System.out.println("当前月最后一天为：" + last);

        getDate();
    }

    private static void getDate() {
        Calendar calendar = Calendar.getInstance();
        // 获取年
        int year = calendar.get(Calendar.YEAR);
        // 获取月,月份范围为 0~11，因此获取月份的时候需要+1才是当前月份值
        int month = calendar.get(Calendar.MONTH) + 1;
        // 获取日
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        // 获取时
        int hour = calendar.get(Calendar.HOUR);
        // 获取分
        int minute = calendar.get(Calendar.MINUTE);
        // 获取秒
        int second = calendar.get(Calendar.SECOND);
        // 星期
        int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        System.out.println("现在是：" + year + "年" + month + "月" + day + "日" + hour + "时" + minute + "分"
         + second + "秒 星期：" + weekday);
    }

    private static void getNextDay() {
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        date = calendar.getTime();
        System.out.println(date);
    }

    private static void getNextDay1() {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = localDate.minusDays(-1);
        System.out.println(localDate);
    }

    private static void test() {
//        Arrays.asList("a", "b", "c").forEach(e -> System.out.println((e)));
        System.out.println();
        String s1 = new String("11");
        s1.intern();
        String s2 = "11";
        System.out.println(s1 == s2);
    }


}
