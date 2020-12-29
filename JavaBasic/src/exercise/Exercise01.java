package exercise;

import java.util.Objects;

/**
 * 训练题-Object
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class Exercise01 {
    public static void main(String[] args) {
        Trapezoid t = new Trapezoid( 30 , 40 , 50 ); // 创建 Trapezoid 实例
        t.calculate() ; // 计算梯形面积
        System.out.println( t ); // 输出梯形信息和梯形面积

        Sector s = new Sector( 5,180 );
        s.calculate() ; // 计算扇形面积
        System.out.println( s ); // 输出扇形信息和扇形面积
    }
}

class Shape {
    // 包含一个用于记录面积数值的实例变量
    protected double area; // 为了让子类能够访问 area 变量，这里修饰符为 protected
    // 包含一个用于表示当前图形类型的实例变量
    // 一个图形一经创建，其类型(type)不允许修改，因此该 字段被设计为 private 修饰。
    private String type; // 创建子类对象时通过调用父类构造方法设置图形种类

    public Shape(String type) {
        this.type = type;
    }

    public void calculate() {
        System.out.println("计算" + this.type + "的面积");
        // 父类 Shape 的 calculate 中仅仅包含一条输出语句，没有任何计算过程
    }

    public String toString() {
        return this.type + "的面积为" + this.area;
    }
}

class Trapezoid extends Shape {
    // 上底
    private double top;
    // 下底
    private double bottom;
    // 高
    private double height;

    public Trapezoid() {
        super("Trapezoid");
    }

    public Trapezoid(double top, double bottom, double height) {
        this();
        this.top = top;
        this.bottom = bottom;
        this.height = height;
    }

    @Override
    public void calculate() {
        super.calculate();
        area = (top + bottom) * height / 2;
    }

    @Override
    public String toString() {
        return "Trapezoid{" +
                "top=" + top +
                ", bottom=" + bottom +
                ", height=" + height +
                "}\n" + super.toString();
    }
}

class Sector extends Shape {
    // Sector 类中有一个表示 圆半径 的 实例变量 ( radius )
    private double radius;
    // Sector 类中有一个表示 扇形弧长 的 实例变量 ( arcLength )
    // 或者可以在 Sector 类中定义 圆心角的角度 ( degree )
    private double degree;

    public Sector() {
        super("Sector");
    }

    public Sector(double radius, double degree) {
        this();
        this.radius = radius;
        this.degree = degree;
    }

    @Override
    public void calculate() {
        super.calculate();
        area = Math.PI * Math.pow(radius, 2) * (degree / 360.0);
    }

    @Override
    public String toString() {
        return "Sector{" +
                "radius=" + radius +
                ", degree=" + degree +
                "}\n" + super.toString();
    }
}

class hashcodeClass{
    private String name ;
    private int age ;
    private char gender ;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        hashcodeClass that = (hashcodeClass)o;

        if (age != that.age) {
            return false;
        }
        if (gender != that.gender) {
            return false;
        }
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        result = 31 * result + (int)gender;
        return result;
    }
    // 31是质子数中一个“不大不小”的存在，如果你使用的是一个如2的较小质数，那么得出的乘积会在一个很小的范围，很容易造成哈希值的冲突。而如果选择一个100以上的质数，得出的哈希值会超出int的最大范围，这两种都不合适。而如果对超过 50,000 个英文单词（由两个不同版本的 Unix 字典合并而成）进行 hash code 运算，并使用常数 31, 33, 37, 39 和 41 作为乘子，每个常数算出的哈希值冲突数都小于7个（国外大神做的测试），那么这几个数就被作为生成hashCode值得备选乘数了。
    // 之所以使用 31， 是因为他是一个奇素数。如果乘数是偶数，并且乘法溢出的话，信息就会丢失，因为与2相乘等价于移位运算（低位补0）。使用素数的好处并不很明显，但是习惯上使用素数来计算散列结果。 31 有个很好的性能，即用移位和减法来代替乘法，可以得到更好的性能： 31 * i == (i << 5）- i， 现代的 VM 可以自动完成这种优化。这个公式可以很简单的推导出来。
}