package abstractfactory;

/**
 * create by tan on 2018/6/19
 * 制造空调的抽象类
 **/
// 抽象产品
public abstract class AirCondition {
}

// 具体产品
class AirCondition320 extends AirCondition {
    public AirCondition320() {
        System.out.println("抽象工厂模式...制造AirCondition320");
    }
}
class AirCondition523 extends AirCondition {
    public AirCondition523() {
        System.out.println("抽象工厂模式...制造AirCondition523");
    }
}