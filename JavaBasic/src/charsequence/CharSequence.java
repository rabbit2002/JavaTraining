package charsequence;

import java.util.Arrays;

/**
 * 字符序列 char sequence 与字节序列 byte sequence
 * <p>
 * java.lang.CharSequence 是个接口
 * 该接口定义了以下抽象方法:
 * int length()
 * char charAt(int index)
 * CharSequence subSequence(int start, int end)
 * String toString() // 从Object继承
 * <p>
 * 以下类实现了该接口
 * java.lang.String
 * java.lang.StringBuffer // TODO 完善
 * java.lang.StringBuilder // TODO 完善
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class CharSequence {
    public static void main(String[] args) {
        // char数组就是有序存放的字符，即 字符序列 ( char sequence )
        char[] chars = {'一', '二', '三', '四'};
        // 直接遍历输出
        System.out.println(chars);
        // 输出hashcode
        System.out.println(chars.toString());
        System.out.println(Arrays.toString(chars));

        // byte数组就是有序存放的字节，即 字节序列 ( byte sequence )
        byte[] bytes = {-128, 100, 40, 126, 65, 80};
        System.out.println(Arrays.toString(bytes));

        for (int i = 0; i < bytes.length; i++) {
            System.out.print((char)bytes[i] + " ");
        }

        java.lang.CharSequence charSequence1 = "ABCD";
        // String 类是 CharSequence 接口的一个实现类
        System.out.println(charSequence1.length());
        System.out.println(charSequence1.charAt(3));
        System.out.println(charSequence1.subSequence(1, 3));
        System.out.println(charSequence1.toString());

        char[] chars1 = {'1', '2', '3', '4'};
        java.lang.CharSequence charSequence2 = new CharImpl(chars1);
        System.out.println(charSequence2.length());
        System.out.println(charSequence2.charAt(1));
        System.out.println(charSequence2.subSequence(1, 2));
        System.out.println(charSequence2.toString());

        java.lang.CharSequence charSequence = null;
        System.out.println(charSequence);
        System.out.println(System.identityHashCode(charSequence));

        charSequence = new String("123456");
        System.out.println(charSequence);
        System.out.println(charSequence.toString());
        System.out.println(charSequence.hashCode());
        System.out.println(System.identityHashCode(charSequence));

        charSequence = new StringBuffer("123456");
        System.out.println(charSequence);
        System.out.println(charSequence.toString());
        System.out.println(charSequence.hashCode());
        System.out.println(System.identityHashCode(charSequence));

        charSequence = new StringBuilder("123456");
        System.out.println(charSequence);
        System.out.println(charSequence.toString());
        System.out.println(charSequence.hashCode());
        System.out.println(System.identityHashCode(charSequence));
    }
}

class CharImpl implements java.lang.CharSequence {

    private char[] value;

    public CharImpl() {
        this.value = new char[0];
    }

    public CharImpl(char[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    @Override
    public int length() {
        return value.length;
    }

    @Override
    public char charAt(int index) {
        return value[index];
    }

    @Override
    public java.lang.CharSequence subSequence(int start, int end) {
        // 返回了一个新的 CharImpl 实例
        return new CharImpl(Arrays.copyOfRange(value, start, end));
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
