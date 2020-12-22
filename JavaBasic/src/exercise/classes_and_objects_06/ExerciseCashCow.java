package exercise.classes_and_objects_06;

import java.util.Random;

/**
 * Exercise 字段和方法 摇钱树
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class ExerciseCashCow {
    /**
     * 摇钱树的高度
     */
    private int height;

    /**
     * 金币数量
     */
    private int goldPiece;

    /**
     * 是否有虫子
     * true-有
     * false-没有
     */
    private boolean wormy;

    /**
     * 杀虫剂数量
     */
    private int pesticide;

    /**
     * 成长
     * 方法执行一次, 摇钱树成长一次, 高度增加 2, 金币数量增加 10
     */
    public void grow() {
        System.out.println("grow!");
        this.height += 2;
        this.goldPiece += 10;
    }

    /**
     * 购买杀虫剂
     * 当有金币时，从树上采摘金币购买农药
     * 每购买一次农药，金币减少 1 个，杀虫剂增加 100
     */
    public void buy() {
        if (this.goldPiece < 0) {
            System.out.println("goldPiece not enough!");
            return;
        }
        System.out.println("buy!");
        this.goldPiece--;
        this.pesticide += 100;

    }

    /**
     * 杀虫
     * 当有虫子时，执行杀虫操作
     * 每执行一次杀虫操作，杀虫剂减少 50 ， 金币增加 5 个
     */
    public void kill() {
        if (!this.wormy) {
            System.out.println("dont need kill!");
            return;
        }
        if (pesticide >= 50) {
            System.out.println("kill!");
            this.pesticide -= 50;
            this.goldPiece += 5;
        } else {
            System.out.println("not enough pesticide!");
        }
    }

    /**
     * 浇水
     * 每次浇水，金币数量增加 5 个，高度增加 1
     * 每次浇水都会导致虫子增加 ( 即 wormy 变为 true )
     */
    public void watering() {
        System.out.println("water!");
        this.height++;
        this.goldPiece += 5;
        this.wormy = true;
    }

    /**
     * 查询状态
     * 通过 show 方法显示 摇钱树的高度 、摇钱树上的金币数量 、是否用虫子 、杀虫剂数量
     */
    public void show() {
        System.out.println("CashCow{" +
                "摇钱树的高度 height: " + height +
                ", 金币数量 goldPiece: " + goldPiece +
                ", 是否有虫子 wormy: " + wormy +
                ", 杀虫剂数量 pesticide: " + pesticide +
                '}');
    }

    public static void main(String[] args) {
        // 创建一个随机数生成器
        Random random = new Random();
        // 创建摇钱树实例(该实例内部包含4个字段)
        ExerciseCashCow cc = new ExerciseCashCow();

        for (int i = 0; i < 10; i++) {
            // 随机产生一个 [ 0 , 4 ) 之间的整数,除了 show 仅有 4 个操作
            int x = random.nextInt(4);
            switch (x) {
                case 0:
                    cc.grow();
                    break;
                case 1:
                    cc.buy();
                    break;
                case 2:
                    cc.kill();
                    break;
                case 3:
                    cc.watering();
                    break;
            }
        }
        cc.show(); // 查询状态
    }
}
