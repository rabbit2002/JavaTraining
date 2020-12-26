package operators;

/**
 * 运算符
 * //TODO 待补充
 *
 * @author RABBIT2002
 * @date 2020/12/25
 */
public class BasicOperators {
    public static void main(String[] args) {
        byteXOR();
    }

    public static void byteXOR() {

        //TODO 迁移到数据类型章节 数值表达

        // 0b / 0B 二进制
        // 0 八进制
        // 默认 十进制
        // 0x 0X 十六进制

        int a = 0b0000_0000_0000_0000_0000_0000_0000_0111; // 7

        int b = 0b0000_0000_0000_0000_0000_0000_0000_0101; // 5
        System.out.println("a = " + a + " , b = " + b);

        a ^= b;
        // 0b0000_0000_0000_0000_0000_0000_0000_0010 2
        System.out.println(a);

        b ^= a;
        // 0b0000_0000_0000_0000_0000_0000_0000_0111 7
        System.out.println(b);

        a ^= b;
        // 0b0000_0000_0000_0000_0000_0000_0000_0101 5
        System.out.println(a);

        System.out.println("a = " + a + " , b = " + b);
    }
}
