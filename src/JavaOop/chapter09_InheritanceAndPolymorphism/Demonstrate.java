package javaOop.chapter09_InheritanceAndPolymorphism;

/**
 * 关于继承和多态中属性和方法调用的演示
 * Inheritance类中 继承类中的属性和方法调用的问题 的演示
 *
 * @author RABBIT2002
 * @date 2020/12/13
 */
class TestMain {
    public static void main(String[] args) {
        Test1 test = new Test2();
        test.func();
    }
}

class Father {
    int a[] = new int[10];

    void func() {
        System.out.println(this.a);
    }
}

class Test1 extends Father {
    int a[] = new int[10];

    @Override
    void func() {
        System.out.println(super.a);
        System.out.println(this.a);
        super.func();
    }
}

class Test2 extends Test1 {
    int a[] = new int[10];

    @Override
    void func() {
        System.out.println(super.a);
        System.out.println(this.a);
        super.func();
    }
}