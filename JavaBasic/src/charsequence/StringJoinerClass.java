package charsequence;

/**
 * JDK8 提供了 StringJoiner 来 操作 字符序列
 * 如果需要频繁拼接字符串建议使用 StringJoiner 来实现
 * <p>
 * 构造方法
 * 1. public StringJoiner(CharSequence delimiter);
 * 2. public StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix);
 * 创建一个被 delimiter 分割的字符串, 并在字符串开始添加 prefix , 字符串末尾添加 suffix
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class StringJoinerClass {

    private static java.util.StringJoiner stringJoiner1;
    private static java.util.StringJoiner stringJoiner2;

    public static void main(String[] args) {
        func1();
        System.out.println();
        func2();
    }

    private static void func1() {
        // public StringJoiner(CharSequence delimiter, CharSequence prefix, CharSequence suffix);
        stringJoiner1 = new java.util.StringJoiner(", ", "< ", " >");

        // add(); 用于添加字符串
        stringJoiner1.add("1");
        stringJoiner1.add("2");
        stringJoiner1.add("3");

        // toString(); 用于转换为字符串
        // < 1, 2, 3 >
        System.out.println(stringJoiner1.toString());
        System.out.println(System.identityHashCode(stringJoiner1));

        System.out.println();

        // public StringJoiner(CharSequence delimiter);
        stringJoiner2 = new java.util.StringJoiner(". ");
        stringJoiner2.add("4");
        stringJoiner2.add("5");
        stringJoiner2.add("6");
        // 4. 5. 6
        System.out.println(stringJoiner2.toString());
        System.out.println(System.identityHashCode(stringJoiner2));
    }

    private static void func2() {
        java.util.StringJoiner stringJoiner = null;
        // merge(); 方法用于合并两个StringJoiner实例, 返回 调用实例
        // stringJoiner = stringJoiner1.merge(stringJoiner2);
        // < 1, 2, 3, 4. 5. 6 >
        // System.out.println(stringJoiner);
        // stringJoiner == stringJoiner1
        // System.out.println(System.identityHashCode(stringJoiner));

        stringJoiner = stringJoiner2.merge(stringJoiner1);
        // 4. 5. 6. 1, 2, 3
        System.out.println(stringJoiner);
        // stringJoiner == stringJoiner2
        System.out.println(System.identityHashCode(stringJoiner));
    }
}
