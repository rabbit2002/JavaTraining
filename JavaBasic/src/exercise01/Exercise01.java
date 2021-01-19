package exercise01;

/**
 * 倒序输出一个字符串
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise01 {
    private String s;

    private String reverse() {
        char[] chars = s.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = chars.length - 1; i >= 0; i--) {
            stringBuffer.append(chars[i]);
        }
        return stringBuffer.toString();
    }

    public Exercise01(String s) {
        this.s = s;
    }

    public static void main(String[] args) {
        Exercise01 exercise01 = new Exercise01("abc");
        System.out.println(exercise01.reverse());
    }
}
