package exercise;

/**
 * 训练题-类继承
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class Exercise04 {
    public static void main(String[] args) {
        Triangle t = new Triangle(); // 创建 Triangle 实例
        t.firstEdge = 44; // 设置边长
        t.secondEdge = 49; // 设置边长
        t.thirdEdge = 52; // 设置边长
        t.calculate(); // 计算三角形面积
        t.description(); // 输出三角形信息和三角形面积

        Circle c = new Circle();
        c.radius = 8; // 设置半径
        c.calculate(); // 计算圆面积
        c.description(); // 输出圆半径和圆面积
    }
}

class Shape04 {
    // 包含一个用于记录面积数值的实例变量
    protected double area; // 为了让子类能够访问 area 变量，这里修饰符为 protected
    // 包含一个用于表示当前图形类型的实例变量
    protected String type; // 为了让子类能够访问 area 变量，这里修饰符为 protected

    public void show() {
        // 在 Shape 类中 show 方法除了输出语句外，没有任何其它代码
        System.out.println(this.type + "的面积为" + this.area);
    }
}

class Triangle extends Shape04 {
    protected double firstEdge;
    protected double secondEdge;
    protected double thirdEdge;

    public Triangle() {
        this.type = "Triangle";
    }

    public void calculate() {
        // 在这里计算三角形的面积，并将面积存储到 area 变量中 ( area 是从父类继承的、可见的实例变量 )
        double temp = (firstEdge + secondEdge + thirdEdge) / 2;
        area = Math.sqrt(temp * (temp - firstEdge) * (temp - secondEdge) * (temp - thirdEdge));
    }

    public void description() {
        // 在这里输出三角形基本信息(比如三边的长度)
        // 最后通过调用从父类继承的、可见的 show 方法输出 三角形的面积
        System.out.println(toString());
        show();
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "firstEdge=" + firstEdge +
                ", secondEdge=" + secondEdge +
                ", thirdEdge=" + thirdEdge +
                '}';
    }
}

class Circle extends Shape04 {
    protected double radius;

    public Circle() {
        this.type = "Circle";
    }

    public void calculate() {
        area = Math.PI * Math.pow(radius, 2);
    }

    public void description() {
        System.out.println(toString());
        show();
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
