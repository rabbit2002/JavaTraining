package javaOop.chapter12_QuickHit;

/**
 * 关卡单元类
 *
 * @author RABBIT2002
 * @date 2020/12/17
 */
public class LevelUnit {
    /**
     * 级别编号
     */
    private String levelNumberName;
    /**
     * 本轮输出字符串长度
     */
    private int strLength;
    /**
     * 本轮输出字符串次数
     */
    private int strTimes;
    /**
     * 本轮闯关时间限制
     */
    private Long timeLimit;
    /**
     * 一次正确输入得分
     */
    private int perScore;

    public static final LevelUnit GET_LEVEL_UNIT(String levelNumberName, int strLength, int strTimes, Long timeLimit, int perScore) {
        return new LevelUnit(levelNumberName, strLength, strTimes, timeLimit, perScore);
    }

    private LevelUnit(String levelNumberName, int strLength, int strTimes, Long timeLimit, int perScore) {
        this.levelNumberName = levelNumberName;
        this.strLength = strLength;
        this.strTimes = strTimes;
        this.timeLimit = timeLimit;
        this.perScore = perScore;
    }

    public String getLevelNumberName() {
        return levelNumberName;
    }

    public int getStrLength() {
        return strLength;
    }

    public int getStrTimes() {
        return strTimes;
    }

    public Long getTimeLimit() {
        return timeLimit;
    }

    public int getPerScore() {
        return perScore;
    }
}