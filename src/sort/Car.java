package sort;

/**
 * create by tan on 2018/6/11
 * Car实体类，对应的属性及方法
 **/
public class Car {
    private String name; // 车的名称
    private String color; // 车身颜色
    private String type; // 车的类型

    // 空参构造
    public Car() {
    }

    // 含参构造
    public Car(String name, String color, String type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
