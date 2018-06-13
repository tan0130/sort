package singleton;

/**
 * create by tan on 2018/6/13
 * 单例模式实现
 * 懒汉式；在第一次调用时实例化自己
 * 资源加载和性能对比：
 * 方式一：在方法上加同步，虽然线程安全了，但是每次都要同步，会影响性能，毕竟大部分情况下是不需要同步的
 * 方式二：在getInstance中做了两次null检查，确保了只有第一次调用单例的时候才会做同步，这样也是线程安全的，同时避免了每次都同步的性能损耗
 * 方式三：利用了classloader的机制来保证初始化instance时只有一个线程，所以也是线程安全的，同时没有性能损耗，所以一般我倾向于使用这一种
 **/
// 懒汉式单例，在第一次调用时实例化自己
public class Singleton {
   private Singleton() {};
   private static Singleton singleton = null;
   // 静态工厂方法
    // 线程不安全
    /*public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }*/

    // 实现线程安全
    // 方式一：在getInstance方法上同步
    /*public synchronized static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }*/

    // 方式二：双重检查锁定
    /*public static Singleton getInstance() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }*/

    // 方式三:静态内部类 这种比上面1、2都好一些，既实现了线程安全，又避免了同步带来的性能影响
    private static class LazyHolder {
        private static final Singleton INSTANCE = new Singleton();
    }
    public static final Singleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
