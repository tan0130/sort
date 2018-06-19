package singleton;

/**
 * create by tan on 2018/6/13
 * 单例模式
 **/
public class TestSingleton {
    // 懒汉式
    private TestSingleton() { }
    private static TestSingleton instance;

    // 线程不安全
    /*public static TestSingleton getInstance() {
        if (null != instance) {
            instance = new TestSingleton();
        }
        return instance;
    }*/

    // 线程安全，在方法上加上synchronized关键字，性能不好
    /*public synchronized static TestSingleton getInstance() {
        if (null != instance) {
            instance = new TestSingleton();
        }
        return instance;
    }*/

    // 线程安全，双重锁检测机制
    /*public  static TestSingleton getInstance() {
        if (null != instance) {
            synchronized(TestSingleton.class) {
                if (null != instance) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }*/

    // 线程安全，静态内部类,不会出现性能损耗
    private static class LayHolder {
        private static final TestSingleton INSTANCE = new TestSingleton();
    }
    private static final TestSingleton getInstance() {
        return LayHolder.INSTANCE;
    }
}
