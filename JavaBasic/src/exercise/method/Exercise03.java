package exercise.method;

/**
 * 训练题-类方法
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class Exercise03 {

    // private 表示私有的
    private static final char[] HEAVENLY_STEMS = {'甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬', '癸'}; // 天干
    // static 表示与类相关的、属于类的
    private static final char[] EARTHLY_BRANCHES = {'子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'};// 地支
    // final 表示最终的、不可更改的
    private static final char[] CHINESE_ZODIAC = {'鼠', '牛', '虎', '兔', '龙', '蛇', '马', '羊', '猴', '鸡', '狗', '猪'};// 生肖

    private static final int CONTRAST = 1984; // 参照年份 ( 甲子年 ，生肖为 鼠 )

    public static void main(String[] args) {
        show();
        System.out.println(seek(2020));
        System.out.println(sign(2020));

    }

    public static void show() {
        for (int i = 0, heavenlyStemsInt = 0, earthlyBranchesInt = 0;
             i < 60;
             i++, heavenlyStemsInt++, earthlyBranchesInt++) {
            heavenlyStemsInt %= 10;
            earthlyBranchesInt %= 12;
            if (i > 0 && i % 12 == 0) {
                System.out.println();
            }
            System.out.print("" + HEAVENLY_STEMS[heavenlyStemsInt] + EARTHLY_BRANCHES[earthlyBranchesInt] + " ");
        }
    }

    public static String seek(int year) {
        int chronology = (year - CONTRAST) % 60;
        String s = null;
        for (int i = 0, heavenlyStemsInt = 0, earthlyBranchesInt = 0;
             i <= chronology;
             i++, heavenlyStemsInt++, earthlyBranchesInt++) {
            heavenlyStemsInt %= 10;
            earthlyBranchesInt %= 12;
            if (i == chronology) {
                s = "" + HEAVENLY_STEMS[heavenlyStemsInt] + EARTHLY_BRANCHES[earthlyBranchesInt];
            }
        }
        return s;
    }

    public static char sign(int year) {
        int zodiac = (year - CONTRAST) % 12;
        return CHINESE_ZODIAC[zodiac];
    }
}
