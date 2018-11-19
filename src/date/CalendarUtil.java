package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * create by 1311230692@qq.com on 2018/11/8 10:05
 * 日期获取工具
 **/
public class CalendarUtil {
    private static Calendar calendar = null;
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static void main(String[] args) {
        System.out.println("格式化当前时间为：" + formatDateTime(calendar));
        System.out.println("获取年月日时分秒：" + getCurrentDatetime(calendar));
        System.out.println("一年后的今天：" + getNextYearDay(calendar));
        System.out.println("去年的今天：" + getPreYearDay(calendar));
        System.out.println("下个月的今天：" + getNextMonthDay(calendar));
        System.out.println("上个月的今天：" + getPreMonthDay(calendar));
        System.out.println("获取任意月的最后一天：" + getMonthLastDay(calendar, 11));
        System.out.println("设置日期：" + setDateTime(calendar, 2018, 8 , 8));
        System.out.println("获取上个月的第一天：" + getPreMonthFirstDay(calendar));
        System.out.println("获取上一月的最后一天：" + getPreMonthLastDay(calendar));
        System.out.println("获取本月的第一天：" + getMonthFirstDay(calendar));
        System.out.println("获取当前月的最后一天：" + getMonthLastDay(calendar));
        System.out.println("加1天：" + getNextDay(calendar));
        System.out.println("减1天：" + getPreDay(calendar));
    }

    // 格式化当前时间，格式为 yyyy-MM-dd HH:mm:ss
    private static String formatDateTime(Calendar calendar) {
        calendar = Calendar.getInstance();
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取当前年月日时分秒以及星期
    private static String getCurrentDatetime(Calendar calendar) {
        calendar = Calendar.getInstance();
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
        return year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second + " 星期：" + weekday;
    }

    // 一年后的今天
    private static String getNextYearDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, 1);
        return simpleDateFormat.format(calendar.getTime());
    }
    // 去年的今天
    private static String getPreYearDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 下个月的今天
    private static String getNextMonthDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 上个月的今天
    private static String getPreMonthDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取上个月的第一天
    private static String getPreMonthFirstDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取上个月的最后一天
    private static String getPreMonthLastDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取这个月的第一天
    private static String getMonthFirstDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取这个月的最后一天
    private static String getMonthLastDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return simpleDateFormat.format(calendar.getTime());
    }

    // 获取任意一个月的最后一天
    private static String getMonthLastDay(Calendar calendar, int month) {
        calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), month, 1);
        calendar.add(Calendar.DATE, -1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 设置日期
    private static String setDateTime(Calendar calendar, int year, int month, int day) {
        calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 加1天
    private static String getNextDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return simpleDateFormat.format(calendar.getTime());
    }

    // 减1天
    private static String getPreDay(Calendar calendar) {
        calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return simpleDateFormat.format(calendar.getTime());
    }
}
