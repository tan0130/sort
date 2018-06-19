package abstractfactory;

/**
 * create by tan on 2018/6/19
 * 抽象工厂模式工厂接口
 **/
// 抽象工厂
public interface AbstractFactory {
    public Engine createEngine(); // 制造发动机
    public AirCondition createAirCondition(); // 制造空调
}

// 具体工厂
// 为宝马320系列生产配件
class FactoryBMW320 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new Engine320();
    }
    @Override
    public AirCondition createAirCondition() {
        return new AirCondition320();
    }
}

// 为宝马523系列生产配件
class FactoryBMW523 implements AbstractFactory {
    @Override
    public Engine createEngine() {
        return new Engine523();
    }
    @Override
    public AirCondition createAirCondition() {
        return new AirCondition523();
    }
}

