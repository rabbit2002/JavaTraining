package exercise.quickHit;

import java.util.Random;

/**
 * 游戏类
 *
 * @author RABBIT2002
 * @date 2020/12/17
 */
public class Game {

    private static final char[] CHARS_OUTPUT;

    static {
        CHARS_OUTPUT = new char[]{'>', '<', '*', '&', '%', '#', '.'};
    }

    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    /**
     * 输出字符串
     *
     * @return java.lang.String 字符串
     */
    public String printStr() {
        int strLength = LevelParam.GET_LEVELS()[player.getLevelNumber()].getStrLength();
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < strLength; i++) {
            stringBuffer.append(CHARS_OUTPUT[random.nextInt(strLength)]);
        }
        String s = stringBuffer.toString();
        System.out.println(s);
        return s;
    }

    public void printResult(String in, String out) {
        if (in.equals(out)) {
            if ((player.getLevelEndTime() - player.getLevelStartTime()) > LevelParam.GET_LEVELS()[player.getLevelNumber()].getTimeLimit()) {
                System.out.println("Too late");
                System.exit(1);
            } else {
                player.setLevelScore(player.getLevelScore() + LevelParam.GET_LEVELS()[player.getLevelNumber()].getPerScore());
                System.out.println("Right! Now Level: " + LevelParam.GET_LEVELS()[player.getLevelNumber()].getLevelNumberName()
                        + ", Score: " + player.getLevelScore() + ", Time used: " + (player.getLevelEndTime() - player.getLevelStartTime()) / 1000.0
                        + ", Time remaining:" + (LevelParam.GET_LEVELS()[player.getLevelNumber()].getTimeLimit() - (player.getLevelEndTime() - player.getLevelStartTime())) / 1000.0);
            }
        } else {
            System.out.println("Input Error");
            System.exit(1);
        }
    }
}