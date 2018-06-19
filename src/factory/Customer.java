package factory;

/**
 * create by tan on 2018/6/19
 * 客户类
 **/
public class Customer {
    public static void main(String[] args) {
        /*Factory fatcory = new Factory();
        BMW bmw320 = fatcory.createBMW(320);
        BMW bmw523 = fatcory.createBMW(523);*/
        FactoryBMW320 factoryBMW320 = new FactoryBMW320();
        BMW320 bmw320 = factoryBMW320.createBMW();

        FactoryBMW523 factoryBMW523 = new FactoryBMW523();
        BMW523 bmw523 = factoryBMW523.createBMW();
    }
}
