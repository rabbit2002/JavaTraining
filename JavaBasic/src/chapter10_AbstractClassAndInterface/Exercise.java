package chapter10_AbstractClassAndInterface;

/**
 * chapter10 AbstractClass and Interface HomeWork Exercise
 * <p>
 * 1.编写程序,在程序中定义一个面积的抽象类Area,定义两个Area类的子类,矩形面积类RectArea和圆形面积类RoundArea,再定义一个测试类Test,
 * 程序实现的要求如下:
 * 1.1.抽象类Area类中只包含一个抽象方法double area();
 * 1.2.子类RoundArea类通过覆盖父类中的抽象方法area();求圆的面积,另一个子类RectArea类通过覆盖父类的抽象方法area();求长方形的面积
 * 1.3.在测试类Test中测试矩形和圆形的面积。
 * <p>
 * 2.创建打印机类Printer,定义抽象方法print();,
 * 创建针式打印机类StylusPrinter和喷墨打印机类InkjetPrinter两个子类,并在各自类中重写print();方法,编写测试类实现两种打印机进行打印,
 * 再添加一个激光打印机LaserPrinter,重写print();方法,修改测试类,实现该打印机打印
 *
 * @author RABBIT2002
 * @date 2020/12/15
 */

// Exercise 1
abstract class Area {
    abstract double getArea();
}

class RoundArea extends Area {
    private static final double PI = Math.PI;
    private double round;

    public RoundArea(double round) {
        this.round = round;
    }

    @Override
    double getArea() {
        return PI * Math.pow(round, 2);
    }
}

class RectArea extends Area {
    private double length;
    private double weight;

    public RectArea(double length, double weight) {
        this.length = length;
        this.weight = weight;
    }

    @Override
    double getArea() {
        return length * weight;
    }
}

// Exercise 2
interface Printer {
    void print();
}

class StylusPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("滋滋滋");
    }
}

class InkjetPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("噗噗噗");
    }
}

class LaserPrinter implements Printer {
    @Override
    public void print() {
        System.out.println("biubiubiu");
    }
}

class TestExercise {
    public static void main(String[] args) {
        Area area = null;
        area = new RoundArea(1.23);
        System.out.println(area.getArea());
        area = new RectArea(1.23, 2.34);
        System.out.println(area.getArea());

        Printer printer = null;
        printer = new StylusPrinter();
        printer.print();
        printer = new InkjetPrinter();
        printer.print();
        printer = new LaserPrinter();
        printer.print();
        printer = new Printer() {
            @Override
            public void print() {
                System.out.println("哒哒哒");
            }
        };
        printer.print();
    }

}