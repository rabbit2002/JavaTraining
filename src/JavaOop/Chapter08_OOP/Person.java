package javaOop.Chapter08_OOP;

/**
 * 面向对象
 * 面向对象程序设计(Object Oriented Programming, OOP)中认为:万事万物皆对象
 * 面向对象的三大特性：封装、继承、多态
 * <p>
 * 类:具有相同的状态和行为的一组对象的集合,是实体对象的概念模型,对象进行综合抽象的结果
 * 1.用属性描述对象有什么状态
 * 2.用方法定义对象有什么行为
 * 对象:符合这种类定义的一个实例(instances)
 * 类是对象的模板，对象是类的实例
 * 类和对象的关系就是抽象和具体的关系
 *
 * <p>
 * class是类关键字
 * [访问限制修饰符] class 类名{
 * .    // 定义:类的成员变量/属性/状态
 * .    // 成员变量分配在堆中,会在创建时初始化为默认值,局部变量则不会
 * .    // 作用域:类内
 * .    [访问限制修饰符] 数据类型 属性名
 * .    // 定义 类的成员方法/方法/行为
 * .    [访问限制修饰符] 返回值类型 方法名称([形式参数类型 形式参数名称, ...]){...}
 * }
 * <p>
 * 创建对象实例
 * 类名 对象名 = new 类名();
 * 类名-对象数据类型 new-实例化 类名()-类构造方法
 * 使用new关键字实例化后,在堆中创建该对象的实例,在栈中创建对象名,其指针指向该内存
 * // TODO 具体分配内存细节
 * // TODO 第一次加载时加载至方法区细节
 * // TODO 对象数组在内存中的分配地址细节
 * <p>
 * 使用 '.' 运算符调用对象的属性和方法
 * <p>
 * 方法重载
 * 在同一类中,方法名相同,方法参数不同(个数/类型/顺序),与返回值无关的多个方法称为方法重载
 * 方法调用时,JVM会自动根据主调方法的参数来决定调用哪个重载形势的方法
 *
 * @author RABBIT2002
 * @date 2020/12/5
 */
public class Person {
    public String name;
    public String gender;
    public int age;

    public void work() {
        System.out.println(this.name + ":吃吃睡睡");
    }

    public int work(String s) {
        System.out.println(this.name + ":" + s);
        return 1;
    }

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.name = "a";
        person1.gender = "m";
        person1.age = 20;
        person1.work();
        person1.work("玩游戏");
    }

}
