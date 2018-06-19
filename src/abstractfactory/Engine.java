package abstractfactory;

/**
 * create by tan on 2018/6/19
 * 制造发动机引擎的抽象类
 **/
// 抽象产品
public abstract class Engine {
}

// 具体产品
class Engine320 extends Engine {
    public Engine320() {
        System.out.println("抽象工厂模式...制造Engine320");
    }
}
class Engine523 extends Engine {
    public Engine523() {
        System.out.println("抽象工厂模式...制造Engine523");
    }
}
