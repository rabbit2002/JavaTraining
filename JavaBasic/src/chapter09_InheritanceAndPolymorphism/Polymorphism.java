package chapter09_InheritanceAndPolymorphism;

/**
 * 面向对象的三大特性：封装、继承、多态
 * <p>
 * 多态
 * <p>
 * 引用不同类型的对象,自动调用引用的对象的方法,针对不同的对象类型,响应不同的操作
 * 多态的表现形式:类继承,抽象类,接口,其中接口是多态的主要表现形式
 * <p>
 * 首先,子类继承父类后,会继承父类除了构造方法和静态方法的所有的属性和方法,
 * 如果子类重写父类方法,在没有super.func()时,不会调用父类方法,只会执行子类方法,
 * 即,子类重写的方法覆盖了父类方法,使其不可见,除非主动调用,否则不会执行
 * 1.所以在类继承中方法重写,才能有多种表现形式,是多态的基础
 * <p>
 * 子类的所有属性和方法都会继承自父类,所以父类中的所有方法在子类中一定存在,
 * 且父类只知道自己的属性和方法,对于子类新增的属性和方法是未知的,
 * <p>
 * 当,父类对象指向子类实例时,执行父类方法时一定会执行该指向的子类实例的该方法,
 * 如果被重写,执行该重写方法,否则执行父类方法(此时子类方法与父类方法指向相同)(参见上一节)
 * <p>
 * 因为是一种接口(函数)的多种实现(重写),具体那种实现由调用时决定,
 * 2.所以只有是父类引用指向子类对象才行,
 * 如果是子类引用指向子类对象时,已经确定对象类型了,不能变了
 * <p>
 * 父类引用指针只知道自己是父类类型,不知道自己是子类类型,也就不能执行子类的新方法,
 * 而如要执行子类的新方法时,则需要将父类的引用指针类型造型为子类的引用指针类型,
 * 因为只有自己是哪个类型才能执行哪个类型的方法
 * <p>
 * 因为父类指针和子类指针并不是同一类指针,所以需要类型转换,分为 向上造型 和 向下造型
 * <p>
 * 向上造型又称:里氏替换原则
 * 向上造型(自动):父类类型指针指向子类类型实例,子类向父类转换
 * 可以理解为,父类是个小框,子类是个包含小框的大框,用父类指针的指向小框中的内容是可以的,所以是自动造型
 * 向下造型(强制):子类类型指针指向父类类型实例,父类向子类转换
 * 可以理解为,1.这个父类指针只能指向小框,指向大框需要强制要求,2.而且父类并不知道需要转换为那个子类,也需要强制指定
 * 而当向下造型错误时,比如把不是这个子类的父类指针强制造型为该类就会报错(ClassCastException),因为框框不一样
 * <p>
 * 在抽象类和接口中较常用多态,且向下造型一般用的不多
 * <p>
 * 多态使用有很多种:主要说明以下两种:
 * 1.父类引用作为方法参数
 * .    public void func(Father father) {
 * .        father.func();
 * .    }
 * 2.父类引用作为方法返回值
 * .    public Father func() {
 * .        return New Son();
 * .    }
 * <p>
 * 多态还分为设计时多态/运行时多态:设计时多态指方法重载,运行时多态指方法重写及父类指针指向子类对象
 * <p>
 * <p>
 * instanceof 运算符:
 * (instance) instanceof (Class/Interface)
 * 当 instance 为 Class 的实例，或是其 直接/间接子类，或是其 Interface 的实现，
 * 结果返回 true,否则返回 false
 * 编译器会检查 instance 是否能转换成右边的 Class 类型,如果不能转换则直接报错,
 * 如果不能确定类型,则通过编译,具体看运行时定
 * https://www.cnblogs.com/ysocean/p/8486500.html
 * // TODO 完善 instanceof
 *
 * @author RABBIT2002
 * @date 2020/12/9
 */
public class Polymorphism {
    public static void main(String[] args) {

        Pat pat = null;

        // 传统写法
        // pat=new Pat("Pat");
        // pat.say();
        // Cat cat = new Cat("Cat");
        // cat.say();
        // cat.eatFish();
        // Dog dog = new Dog("Dog");
        // dog.say();
        // dog.eatBones();

        System.out.println("--Pat Start--");
        pat = new Pat("Pat");
        System.out.println("--Pat Say--");
        pat.say();
        System.out.println("--Pat End--");

        System.out.println();

        System.out.println("--Cat Start--");
        pat = new Cat("Cat");
        System.out.println("--Cat Say--");
        pat.say();
        System.out.println("--Cat Say(Cast)--");
        ((Cat)pat).say();
        System.out.println("--Cat Eat(Cast)--");
        ((Cat)pat).eatFish();
        System.out.println("--Cat End--");

        System.out.println();

        System.out.println("--Dog Start--");
        pat = new Dog("Dog");
        System.out.println("--Dog Say--");
        pat.say();
        System.out.println("--Dog Say(Cast)--");
        ((Dog)pat).say();
        System.out.println("--Dog Eat(Cast)--");
        ((Dog)pat).eatBones();
        System.out.println("--Dog End--");
    }
}

// abstract class Pat {
class Pat {
    private String name;

    public Pat(String name) {
        this.name = name;
    }

    // public abstract void say();
    public void say() {
        System.out.println(this.getName() + ": is say");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Cat extends Pat {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void say() {
        // super.say();
        System.out.println(this.getName() + ": is say meow");
    }

    public void eatFish() {
        System.out.println(this.getName() + ": is eat fish");
    }
}

class Dog extends Pat {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void say() {
        // super.say();
        System.out.println(this.getName() + ": is say bark");
    }

    public void eatBones() {
        System.out.println(this.getName() + ": is eat bones");
    }
}
