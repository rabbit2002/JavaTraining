package charsequence;

import charsequence.util.StringBufferHelper;

/**
 * 1. 自JDK5开始, 添加 AbstractStringBuilder 抽象类
 * StringBuilder(JDK5) 与 StringBuffer 均直接继承自该类
 * 2. StringBuilder 与 StringBuffer 均是 final class
 * <p>
 * 与 String 不同的是, 在 AbstractStringBuilder 类内部, 实例属性没有 final 修饰, 是可变的:
 * byte[] value;
 * byte coder;
 * int count;
 * <p>
 * stringBuffer 有 capacity(容量) 和 length(长度) 两个属性,
 * 容量 表示当前数组能存放多少个字符, 长度 表示当前数组存放了多少个字符,
 * 当容量不足时会自动扩容, 数组也会重新生成
 * 1. 当使用 trimToSize(); 方法时, 如果此时 capacity > length,
 * 则会生成一个新的缓冲区, 将 capacity 压缩为 length 大小
 * 2. 当使用 setLength(int newLength); 方法时, 会直接改变 length属性 的值
 * (并不会修改数组中的内容), 此时如果重新添加内容 则会覆盖缓冲区的内容
 * (可用在循环输出中, 直接覆盖缓冲区, 而不是每次创建新的 stringBuffer实例 , 减少内存开支)
 * <p>
 * StringBuffer 中的所有实例方法 都会直接修改当前的 StringBuffer 实例
 * (String是会创建新的实例)
 * <p>
 * 常用的实例方法:
 * 1. append(); 在末尾追加
 * 2. insert(int offset, String str); 在 offset 处, 插入字符串str
 * 3. delete(int start, int end); 删除 [start, end) 的字符
 * 4. indexOf(String str); 返回 str 首次出现的位置
 * 5. lastIndexOf(String str); 返回 str 最后出现的位置
 * 6. replace(int start, int end, String str); 使用 str 替换 [start, end) 的字符
 * 7. reverse(); 翻转字符缓冲区
 * <p>
 * 8. deleteCharAt(int index); 删除 index位置 的字符
 * 9. setCharAt(int index, char ch); 设置 index位置 的字符为 ch
 * <p>
 * 注意: StringBuffer 与 StringBuilder 均没有重写 Object 的 equals();
 * 可以通过将 StringBuffer 或 StringBuilder 转换为 String实例 后,
 * 使用 String类 的 contentEquals(CharSequence cs) 方法比较内容
 *
 * @author RABBIT2002
 * @date 2020/12/25
 */
public class StringBufferClass {
    public static void main(String[] args) {
        func1();
    }

    private static void func1() {
        StringBuffer stringBuffer = new StringBuffer();
        StringBufferHelper.show(stringBuffer);

        stringBuffer.append("1");
        StringBufferHelper.show(stringBuffer);

        stringBuffer.append("234567890ABCDEF");
        StringBufferHelper.show(stringBuffer);

        stringBuffer.append("*");
        StringBufferHelper.show(stringBuffer);

        stringBuffer.trimToSize();
        StringBufferHelper.show(stringBuffer);

        stringBuffer.setLength(0);
        StringBufferHelper.show(stringBuffer);
    }

    private static void func2() {
        StringBuffer stringBuffer = new StringBuffer("*");

        stringBuffer.append("123");
        System.out.println(stringBuffer);

        stringBuffer.insert(1, "---");
        System.out.println(stringBuffer);

        stringBuffer.delete(2, 4);
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.indexOf("2"));
        System.out.println(stringBuffer.lastIndexOf("1"));

        stringBuffer.replace(2, 4, "$$");
        System.out.println(stringBuffer);

        stringBuffer.reverse();
        System.out.println(stringBuffer);
    }

    private static void func3() {
        StringBuffer stringBuffer = new StringBuffer("12345");

        stringBuffer.deleteCharAt(2);
        System.out.println(stringBuffer);

        stringBuffer.setCharAt(2, '*');
        System.out.println(stringBuffer);
    }

    private static void func4() {
        StringBuffer stringBuffer1 = new StringBuffer("12345");
        StringBuffer stringBuffer2 = new StringBuffer("12345");

        System.out.println(stringBuffer1.equals(stringBuffer2));
        System.out.println(stringBuffer1.toString().contentEquals(stringBuffer2));
    }
}
