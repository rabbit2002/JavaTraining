package chapter12_QuickHit;

import java.util.Scanner;

/**
 * 玩家类
 *
 * @author RABBIT2002
 * @date 2020/12/17
 */
public class Player {
    /**
     * 当前级别
     */
    private int levelNumber;
    /**
     * 当前级别积分
     */
    private int levelScore;
    /**
     * 当前级别开始时间
     */
    private long levelStartTime;
    /**
     * 当前回合结束时间
     */
    private long levelEndTime;

    private void init() {
        this.levelNumber = 0;
        this.levelScore = 0;
        this.levelStartTime = 0L;
        this.levelEndTime = 0L;
    }

    public Player() {
        this.init();
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }

    public int getLevelScore() {
        return levelScore;
    }

    public void setLevelScore(int levelScore) {
        this.levelScore = levelScore;
    }

    public long getLevelStartTime() {
        return levelStartTime;
    }

    public void setLevelStartTime(long levelStartTime) {
        this.levelStartTime = levelStartTime;
    }

    public long getLevelEndTime() {
        return levelEndTime;
    }

    public void setLevelEndTime(long levelEndTime) {
        this.levelEndTime = levelEndTime;
    }

    public void play() {
        Game game = new Game(this);
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < LevelParam.GET_LEVELS().length; i++) {

            this.setLevelStartTime(System.currentTimeMillis());

            for (int j = 0; j < LevelParam.GET_LEVELS()[getLevelNumber()].getStrTimes(); j++) {
                System.out.println("READY:");
                String outStr = game.printStr();
                String inStr = scanner.next();
                this.setLevelEndTime(System.currentTimeMillis());
                game.printResult(inStr, outStr);
                System.out.println();
            }

            this.setLevelNumber(this.getLevelNumber() + 1);
            this.setLevelScore(0);

            if (this.getLevelNumber() == 6) {
                System.out.println("Win!");
                break;
            }
        }
    }
}