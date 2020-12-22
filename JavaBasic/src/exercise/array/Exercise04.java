package exercise.array;

/**
 * Exercise04s
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class Exercise04 {
    public static void main(String[] args) {
        char[] heavenlyStems = {'甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬', '癸'};
        char[] earthlyBranches = {'子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'};

        // 输出六十甲子名称(要求每行输出12个，总共输出 5 行)

        for (int i = 0, heavenlyStemsInt = 0, earthlyBranchesInt = 0;
             i < 60;
             i++, heavenlyStemsInt++, earthlyBranchesInt++) {

            heavenlyStemsInt %= 10;
            earthlyBranchesInt %= 12;

            if (i > 0 && i % 12 == 0) {
                System.out.println();
            }

            System.out.print("" + heavenlyStems[heavenlyStemsInt] + earthlyBranches[earthlyBranchesInt] + " ");
        }
    }
}
