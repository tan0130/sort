package singleton;

import java.util.HashMap;
import java.util.Map;

/**
 * create by tan on 2018/6/13
 * 登记式单例（可忽略）
 **/
public class Singleton2 {
    private static Map<String,Singleton2> map = new HashMap<String,Singleton2>();
    static{
        Singleton2 single = new Singleton2();
        map.put(single.getClass().getName(), single);
    }
    //保护的默认构造子
    protected Singleton2(){}
    //静态工厂方法,返还此类惟一的实例
    public static Singleton2 getInstance(String name) {
        if (name == null) {
            name = Singleton2.class.getName();
            System.out.println("name == null"+"--->name="+name);
        }
        if (map.get(name) == null) {
            try {
                map.put(name, (Singleton2) Class.forName(name).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return map.get(name);
    }
    //一个示意性的商业方法
    public String about() {
        return "Hello, I am RegSingleton.";
    }
    public static void main(String[] args) {
        Singleton2 single2 = Singleton2.getInstance(null);
        System.out.println(single2.about());
    }
}
