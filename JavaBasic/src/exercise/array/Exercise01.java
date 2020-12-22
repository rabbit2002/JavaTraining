package exercise.array;

/**
 * Exercise01
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class Exercise01 {
    public static void main(String[] args) {

        char[][] chars = {
                {'春', '眠', '不', '觉', '晓'},
                {'处', '处', '闻', '啼', '鸟'},
                {'夜', '来', '风', '雨', '声'},
                {'花', '落', '知', '多', '少'}
        };

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        for (int i = 0; i < chars[0].length; i++) {
            for (int j = chars.length - 1; j >= 0; j--) {
                System.out.print(chars[j][i] + " ");
            }
            System.out.println();
        }

    }
}
