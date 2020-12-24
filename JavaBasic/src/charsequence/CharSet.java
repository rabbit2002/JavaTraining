package charsequence;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * 字符编码
 * java.nio.charset.Charset 类的实例表示字符编码
 * 1.Charset.defaultCharset() 返回 JVM 的默认 charset 实例
 * 2.Charset.forName( String charsetName ) 返回 指定名称的 Charset 实例
 * 3.Charset.isSupported( String charsetName ) 判断当前JVM是否支持指定的 字符编码
 * <p>
 * 字符序列(char sequence) 转换为 字节序列(byte sequence) 的过程被称作 编码(encode)
 * 编码时 必须指定 相应的 字符集(charset),若未显式设置则使用 平台默认字符集
 * 字节序列(byte sequence) 转换为 字符序列(char sequence) 的过程被称作 解码(decode)
 * <p>
 * String类的构造方法
 * // 通过使用平台的默认字符集 解码 指定的 byte数组，构造一个新的 String实例
 * String(byte[] bytes);
 * // 通过使用平台的默认字符集 解码 指定的 byte数组，构造一个新的 String实例
 * String(byte bytes[], int offset, int length);
 * // 通过使用指定的 charset 解码指定的 byte数组，构造一个新的 String实例
 * String(byte bytes[], Charset charset);
 * String(byte bytes[], String charsetName);
 * // 通过使用指定的 charset 解码指定的 byte数组，构造一个新的 String实例
 * String(byte bytes[], int offset, int length, Charset charset);
 * String(byte bytes[], int offset, int length, String charsetName)
 * <p>
 * ASCII American Standard Code for Information Interchange
 * 共128位: 0-9[48-57] A-Z[65-90] a-z[97-122]
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class CharSet {
    public static void main(String[] args) {
        // The default charset is determined during virtual-machine startup
        // and typically depends upon the locale and charset of the underlying operating system.
        Charset charset = Charset.defaultCharset();
        System.out.println(charset);

        // UTF-8 可变长度1-4字节 中文一般3字节
        Charset utf8CharSet = Charset.forName("UTF-8");
        // GBK 2字节
        Charset gbkCharSet = Charset.forName("GBK");
        System.out.println(utf8CharSet);

        System.out.println(Charset.isSupported("GBK"));

        // 字符序列 char sequence
        String s = new String("这是一句String");
        System.out.println(s.length());

        // 字节序列 byte sequence
        // 平台的默认字符集
        byte[] bytes = s.getBytes();
        // bytes=s.getBytes(StandardCharsets.UTF_8);
        System.out.println(bytes.length);

        // getBytes 推荐使用传入Charset 实例,而不是String charsetName, 后者要转换时抛出异常
        bytes = s.getBytes(gbkCharSet);
        System.out.println(bytes.length);

        final String STRING = new String("兔兔: _(:з」∠)_");

        byte[] bytes1 = STRING.getBytes();
        System.out.println(Arrays.toString(bytes1));

        bytes1 = STRING.getBytes(utf8CharSet);
        System.out.println(Arrays.toString(bytes1));

        bytes1 = STRING.getBytes(gbkCharSet);
        System.out.println(Arrays.toString(bytes1));

        byte[] bytes2 = new byte[]{-51, -61, -51, -61, 58, 32, 95, 40, 58, -89, -39, -95, -71, -95, -49, 41, 95};
        System.out.println(new String(bytes2));
        System.out.println(new String(bytes2, utf8CharSet));
        System.out.println(new String(bytes2, gbkCharSet));

    }
}
