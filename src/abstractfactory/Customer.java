package abstractfactory;

/**
 * create by tan on 2018/6/19
 * 抽象工厂模式主函数
 **/
public class Customer {
    public static void main(String[] args) {
        // 生产宝马320系列配件
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        factoryBMW320.createEngine();
        factoryBMW320.createAirCondition();

        // 生产宝马523系列配件
        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        factoryBMW523.createEngine();
        factoryBMW523.createAirCondition();
    }
}
