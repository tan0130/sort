package factory;

/**
 * create by tan on 2018/6/19
 * 工厂方法模式
 **/
interface FactoryBMW {
    BMW createBMW();
}

class FactoryBMW320 implements FactoryBMW {
    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}

class FactoryBMW523 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {
        return new BMW523();
    }
}
