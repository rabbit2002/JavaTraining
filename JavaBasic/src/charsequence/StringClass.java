package charsequence;

/**
 * java.lang.String 是 java.lang.CharSequence 接口的一个实现类
 * <p>
 * String 是引用类型而不是基本类型
 * <p>
 * String 有两种声明方式:
 * 1. "..."(字面量)  存放在常量池
 * 2. new String(); 存放在堆中
 * 这两种方式均会生成一个 String 实例
 * <p>
 * 变量类型 变量 赋值(=) 数据;
 * 对于基本类型, 变量存储的数据是数值本身
 * 对于引用类型, 变量存储的数据是地址
 * 运算符 == 用于比较两个值是否相等,
 * 对于基本类型比较数值本身是否相等,对于引用类型比较地址是否相等
 * String类 重写了从 Object继承的 equals 方法
 * <p>
 * 1. 有变量参与的字符串连接操作都会返回新的 String 实例, 参见func2();
 * 2. 当变量被 final修饰时, 此时变量与字面量相同, 变量连接与字面量连接相同, 返回相同的实例, 参见func3();
 * <p>
 * JDK8(含) 之前使用 StringBuilder 连接字符串
 * 12 new #11 <java/lang/StringBuilder>
 * 16 invokespecial #12 <java/lang/StringBuilder.<init>>
 * 20 invokevirtual #13 <java/lang/StringBuilder.append>
 * 27 invokevirtual #14 <java/lang/StringBuilder.toString>
 * JDK11 中使用 makeConcatWithConstants 连接字符串
 * 14 invokedynamic #11 <makeConcatWithConstants, BootstrapMethods #0>
 * <p>
 * // TODO 完善迁移
 * getChars();
 * toCharArray();
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class StringClass {

    public static void main(String[] args) {

        func1();
        System.out.println();
        func2();
        System.out.println();
        func3();
        System.out.println();
        func4();

    }

    private static void func1() {
        // 变量 str1 的值是 常量池中 "Hello" 实例的 地址
        String str1 = "Hello";
        System.out.println(System.identityHashCode(str1));

        // 变量 str2 的值是 堆内存中 "Hello" 实例的 地址
        String str2 = new String("Hello");
        System.out.println(System.identityHashCode(str2));
    }

    private static void func2() {
        String str10 = "Hello";
        System.out.println("str10: " + System.identityHashCode(str10));
        String str11 = "World";
        System.out.println("str11: " + System.identityHashCode(str11));

        // 有变量参与的字符串连接操作都会返回新的 String 实例
        // 连接字符串在Java8(含)之前和之后不一样
        // JDK8 之前使用 StringBuilder JDK11 中使用 makeConcatWithConstants

        String str12 = str10 + str11;
        System.out.println("str12: " + System.identityHashCode(str12));
        String str13 = "Hello" + str11;
        System.out.println("str13: " + System.identityHashCode(str13));
        String str14 = str10 + "World";
        System.out.println("str14: " + System.identityHashCode(str14));

        // str12 != str13 != str14
        System.out.println(str12 == str13 || str12 == str14 || str13 == str14);
    }

    private static void func3() {
        // ldc #9 <HelloWorld>
        String str00 = "HelloWorld";
        System.out.println("str00: " + System.identityHashCode(str00));
        // ldc #9 <HelloWorld>
        String str01 = "Hello" + "World";
        System.out.println("str01: " + System.identityHashCode(str01));
        // true
        System.out.println("str00 == str01: " + (str00 == str01));

        System.out.println();

        final String STR_10 = "Hello";
        System.out.println("str10: " + System.identityHashCode(STR_10));
        final String STR_11 = "World";
        System.out.println("str11: " + System.identityHashCode(STR_11));

        // ldc #9 <HelloWorld>
        String str12 = STR_10 + STR_11;
        System.out.println("str12: " + System.identityHashCode(str12));
        // ldc #9 <HelloWorld>
        String str13 = "Hello" + STR_11;
        System.out.println("str13: " + System.identityHashCode(str13));
        // ldc #9 <HelloWorld>
        String str14 = STR_10 + "World";
        System.out.println("str14: " + System.identityHashCode(str14));

        // str00 == str01 == str12 == str13 ==str14
        System.out.println(str00 == str12 && str12 == str13 && str12 == str14);
    }

    private static void func4() {
        String s = "123456789";

        // getChars(); 将字符序列中 [srcBegin, srcEnd) 的 字符复制到 dst[] 中, 从 dstBegin 开始
        char[] chars1 = new char[10];
        s.getChars(2, 6, chars1, 2);
        System.out.println(chars1);

        // toCharArray(); 将 字符序列 转换为 char[], 返回 char[]
        char[] chars2 = s.toCharArray();
        System.out.println(chars2);
    }
}
