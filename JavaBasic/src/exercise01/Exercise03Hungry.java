package exercise01;

/**
 * 单例模式 饿汉式
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise03Hungry {

    private static Exercise03Hungry exercise03Hungry =new Exercise03Hungry();

    private Exercise03Hungry() {
    }

    public static Exercise03Hungry getExercise03Hungry() {
        return exercise03Hungry;
    }
}
