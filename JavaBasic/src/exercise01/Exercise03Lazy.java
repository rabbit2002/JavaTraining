package exercise01;

/**
 * 单例模式 懒汉式
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise03Lazy {

    private static Exercise03Lazy Exercise03Lazy = null;

    private Exercise03Lazy() {
    }

    public static Exercise03Lazy getExercise03Lazy() {
        if (Exercise03Lazy == null) {
            Exercise03Lazy = new Exercise03Lazy();
        }
        return Exercise03Lazy;
    }
}
