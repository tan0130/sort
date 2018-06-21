package strategy;

/**
 * create by tan on 2018/6/20
 * 抽象类
 **/
// 抽象产品
public abstract class AudiCar {
    private String name;

    public abstract void makeCar();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

// 具体产品
class AudiA6 extends AudiCar {
    public void makeCar() {
        System.out.println(this.getName() + "...go");
    }
}
class AudiA4 extends AudiCar {
    public void makeCar() {
        System.out.println(this.getName() + "...go");
    }
}
