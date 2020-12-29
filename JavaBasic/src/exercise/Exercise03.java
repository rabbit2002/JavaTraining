package exercise;

/**
 * 训练题-封装
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class Exercise03 {
    public static void main(String[] args) {
//        Decimal d1 = new Decimal(9);
//        String s1 = d1.toBinaryString();
//        System.out.println(s1);

        Decimal d2 = new Decimal(2147483647);
        String s2 = d2.toHexString();
        System.out.println(s2);
    }
}

class Decimal {

    // 声明一个用来保存整数的字段
    private final long value; // 注意这里封装的是 long 类型的数值

    // 声明一个可以接受单个整数值的构造方法
    public Decimal(long value) {
        this.value = value;
    }

    public String toBinaryString() {
        char[] chars = new char[32];
        long temp = this.value;
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = (char)((temp % 2) + 48);
            temp = temp >> 1;
        }
        return String.valueOf(chars);
    }

    public String toHexString() {
//        System.out.println((int)'0');
//        System.out.println((int)'9');
//        System.out.println((int)'A');
//        System.out.println((int)'F');
        char[] chars = new char[8];
        long temp = this.value;
        for (int i = chars.length - 1; i >= 0; i--) {
            chars[i] = (char)((temp % 16)<10?(temp % 16) + 48:(temp % 16)-10+65);
            temp = temp >> 4;

        }
        return String.valueOf(chars);
    }
}
