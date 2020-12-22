package exercise.array;

/**
 * Exercise03
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class Exercise03 {
    public static void main(String[] args) {
        int[] first = {1, 3, 5, 7, 9};
        int[] second = {1, 3, 5, 9, 7};
        int[] third = {1, 3, 5, 7, 9};
        int[] fourth = {1, 3, 5, 7};

        boolean x = equal(first, second);
        System.out.println(x); // false

        x = equal(first, third);
        System.out.println(x); // true

        x = equal(first, fourth);
        System.out.println(x); // false
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

}
