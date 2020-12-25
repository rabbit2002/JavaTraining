package exercise.method;

/**
 * 训练题-方法重载
 *
 * @author RABBIT2002
 * @date 2020/12/24
 */
public class Exercise05 {

    public static void main(String[] args) {
        System.out.println(Exercise05.equal(new int[]{1, 2, 3}, new int[]{1, 2, 3}));
        System.out.println(Exercise05.equal(new char[]{'1', '2'}, new char[]{'1', '2'}));
    }

    public static boolean equal(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }
        if (first.length == 0) {
            return true;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean equal(char[] first, char[] second) {
        if (first.length != second.length) {
            return false;
        }
        if (first.length == 0) {
            return true;
        }
        for (int i = 0; i < first.length; i++) {
            if (first[i] - second[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
