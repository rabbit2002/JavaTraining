package exercise.method;

/**
 * 训练题-类方法
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class Exercise03 {

    // 天干
    private static final char[] HEAVENLY_STEMS;
    // 地支
    private static final char[] EARTHLY_BRANCHES;
    // 生肖
    private static final char[] CHINESE_ZODIAC;

    // 参照年份 ( 甲子年 ，生肖为 鼠 )
    private static final int CONTRAST = 1984;

    static {
        HEAVENLY_STEMS = new char[]{'甲', '乙', '丙', '丁', '戊', '己', '庚', '辛', '壬', '癸'};
        EARTHLY_BRANCHES = new char[]{'子', '丑', '寅', '卯', '辰', '巳', '午', '未', '申', '酉', '戌', '亥'};
        CHINESE_ZODIAC = new char[]{'鼠', '牛', '虎', '兔', '龙', '蛇', '马', '羊', '猴', '鸡', '狗', '猪'};
    }

    public static void main(String[] args) {
        show();
        System.out.println(seek(1863));
        System.out.println(sign(1863));
    }

    public static void show() {
        for (int i = 0; i < 60; i++) {
            System.out.print(generate(i) + ((i + 1) % 12 == 0 ? "\n" : " "));
        }
    }

    public static String generate(int x) {
        return HEAVENLY_STEMS[x % HEAVENLY_STEMS.length]
                + ""
                + EARTHLY_BRANCHES[x % EARTHLY_BRANCHES.length];
    }

    public static String seek(int year) {
        int length = HEAVENLY_STEMS.length * CHINESE_ZODIAC.length;
        return generate((length - Math.abs(year - CONTRAST) % length) % length);
    }

    public static char sign(int year) {
        int length = CHINESE_ZODIAC.length;
        return CHINESE_ZODIAC[(length - Math.abs(year - CONTRAST) % length) % length];
    }
}
