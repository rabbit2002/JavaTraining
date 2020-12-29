package comparingobjects;

import java.util.Date;

/**
 * 在 基本数据类型 中 除了 Boolean 以外, 都可以使用 比较运算符 比较大小
 * 在 引用类型 中 不能使用 比较运算符 比较大小, 部分类定义了用于比较的方法,
 * 例如: Date类中 date.after()等
 * 但是, 如果一个类实现了 Comparable接口, 这个类的实例都可以使用 compareTo方法 进行比较
 * <p>
 * java.lang.Comparable 接口
 * <p>
 * This interface imposes a total ordering on the objects of each class that implements it.
 * 这个接口 对每个实现的类的对象 强加了一个总排序
 * This ordering is referred to as the class's natural ordering,
 * and the class's compareTo method is referred to as its natural comparison method.
 * 这种排序称为 类的 自然排序, 这个类的 compareTo方法 称为类的 自然比较方法
 * <p>
 * 在实现 Comparable接口 时, 建议显示指定类型参数
 * o1.compareTo(o2) 当 o1 小于 等于 大于 o2 时, 返回 -1 0 1
 *
 * 自然排序, 用一种固定排序顺序排序
 * 比较器排序, 可以自定义排序顺序, 或者对没有定义自然排序的类实例进行排序
 *
 * @author RABBIT2002
 * @date 2020/12/28
 */
public class ComparableClass {
    public static void main(String[] args) {
        func1();
    }

    private static void func1() {
        Date date1 = new Date(50);
        Date date2 = new Date(100);
        System.out.println(date1.compareTo(date2));

        String s1 = "a";
        String s2 = "a";
        System.out.println(s1.compareTo(s2));

        StringBuffer stringBuffer1 = new StringBuffer("222");
        StringBuffer stringBuffer2 = new StringBuffer("111");
        System.out.println(stringBuffer1.compareTo(stringBuffer2));
    }
}


