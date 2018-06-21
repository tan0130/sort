package strategy;

/**
 * create by tan on 2018/6/20
 * 客户端 什么都懂，销售部门不用很懂
 **/
public class Customer {
    public static void main(String[] args) {
        AudiCar car = new AudiA6();
        car.setName("A6");

        CarContext context = new CarContext(car);
        context.orderCar();
    }
}
