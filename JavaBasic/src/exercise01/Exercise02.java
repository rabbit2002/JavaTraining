package exercise01;

import java.util.Arrays;
import java.util.Random;

/**
 * 彩票号码生成器
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise02 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(generate()));
    }

    private static int[] generate() {
        boolean[] before = new boolean[34];
        boolean[] after = new boolean[12];
        int[] returns = new int[7];

        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 7; i++) {
            int temp = -1;
            if (i < 5) {

                do {
                    temp = random.nextInt(34);
                } while (before[temp]);

                returns[i] = temp + 1;
                before[temp] = true;
            } else {

                do {
                    temp = random.nextInt(12);
                } while (after[temp]);

                returns[i] = temp + 1;
                after[temp] = true;
            }
        }
        return returns;
    }
}
