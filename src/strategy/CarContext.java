package strategy;

/**
 * create by tan on 2018/6/20
 * 销售部门...服务端
 **/
public class CarContext {
    AudiCar audiCar = null;

    public CarContext(AudiCar audiCar) {
        this.audiCar = audiCar;
    }
    public void orderCar() {
        this.audiCar.makeCar();
    }
}
