package singleton;

/**
 * create by tan on 2018/6/13
 * 测试单例模式，使用懒汉式实现线程安全的方式二：双重检测锁的方式
 **/
public class TestSingleton {
    String name = "";
    private TestSingleton() {}

    private static volatile TestSingleton instance = null;

    public static TestSingleton getInstance() {
        if (instance == null) {
            synchronized (TestSingleton.class) {
                if (instance == null) {
                    instance = new TestSingleton();
                }
            }
        }
        return instance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printMsg(String name) {
        System.out.println("the name is:" + name);
    }

    public static void main(String[] args) {
        
    }
}
