package exercise.classes_and_objects_06;

/**
 * Exercise 类和对象 圆柱体的表面积和体积
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class ExerciseCylinder {
    /**
     * 底面的半径
     */
    double radius;
    /**
     * 高度
     */
    double height;

    /**
     * 计算圆柱体的表面积
     */
    public void squaring() {
        System.out.println(Math.PI * Math.pow(this.radius, 2) * 2 + 2 * Math.PI * this.radius * this.height);
    }

    /**
     * 计算圆柱体的体积
     */
    public void cube() {
        System.out.println(Math.PI * Math.pow(this.radius, 2) * height);
    }

    public static void main(String[] args) {
        ExerciseCylinder c = new ExerciseCylinder();
        c.radius = 20;
        c.height = 20;
        // 计算圆柱体表面积并在控制台输出面积
        c.squaring();
        // 计算圆柱体体积并在控制台输出体积
        c.cube();
    }
}
