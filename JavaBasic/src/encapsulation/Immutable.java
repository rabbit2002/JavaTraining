package encapsulation;

/**
 * 不变模式
 * <p>
 * 分为:
 * 1. 不可变类 (immutable class)
 * 1.1. 类被 final 修饰
 * (被 final 修饰的 class 是  final class , 该 class 不能被继承)
 * 1.2. 所有属性被 final 修饰
 * (被 final 修饰的 variable 是 final variable , 该 variable 初始化后不可更改)
 * 1.3. 不提供实例变量的修改器 (即实例变量对应的setter)
 * <p>
 * 2. 不可变对象 (immutable object)
 * 2.1. 一个对象一经创建, 其状态再也无法改变
 * 2.2. 所谓状态不可变是该对象的实例变量的值再也无法修改
 * <p>
 * 8种基本数据类型对应的包装类都是不可变类
 * String 对象 是 不可变对象
 *
 * @author RABBIT2002
 * @date 2020/12/24
 */
public final class Immutable {
    private final int variable;

    public Immutable(int variable) {
        this.variable = variable;
    }

    public static void main(String[] args) {
        Immutable immutable = new Immutable(100);
    }
}
