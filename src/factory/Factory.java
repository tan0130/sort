package factory;

/**
 * create by tan on 2018/6/19
 * 简单工厂模式
 **/
public class Factory {
    public BMW createBMW(int type) {
        switch (type) {
            case 320:
                return new BMW320();
            case 523:
                return new BMW523();
            default:
                break;
        }
        return null;
    }
}
