package exercise.method;

/**
 * 训练题-可变长参数
 *
 * @author RABBIT2002
 * @date 2020/12/24
 */
public class Exercise04 {
    public static void main(String[] args) {
        MathHelper mathHelper = MathHelper.getInstance();

        System.out.println(mathHelper.max(99L, 77, 66, 'x'));
        System.out.println(mathHelper.min(99L, 77, 66, 'x'));

        System.out.println(mathHelper.max(1.2E-2, 99L, 77, 66, 'x'));
        System.out.println(mathHelper.min(1.2E-2, 99L, 77, 66, 'x'));
    }
}

class MathHelper {

    public static MathHelper getInstance() {
        return new MathHelper();
    }

    public long max(long... values) {
        // 找出参数中的最大值并返回
        long tempMax = Long.MIN_VALUE;
        for (long l : values) {
            if (l > tempMax) {
                tempMax = l;
            }
        }
        return tempMax;
    }

    public double max(double... values) {
        // 找出参数中的最大值并返回
        double tempMax = Double.MIN_VALUE;
        for (double v : values) {
            if (v > tempMax) {
                tempMax = v;
            }
        }
        return tempMax;
    }

    public long min(long... values) {
        // 找出参数中的最小值并返回
        long tempMin = Long.MAX_VALUE;
        for (long l : values) {
            if (l < tempMin) {
                tempMin = l;
            }
        }
        return tempMin;
    }

    public double min(double... values) {
        // 找出参数中的最小值并返回
        double tempMin = Double.MAX_VALUE;
        for (double v : values) {
            if (v < tempMin) {
                tempMin = v;
            }
        }
        return tempMin;
    }
}