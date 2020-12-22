package exercise.classes_and_objects_06;

/**
 * Exercise 类和对象 三角形面积
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class ExerciseTriangle {
    double firstEdge;
    double secondEdge;
    double thirdEdge;

    /**
     * 计算面积
     */
    public void squaring() {
        double p = (this.firstEdge + this.secondEdge + this.thirdEdge) / 2.0;
        double s = Math.sqrt(p * (p - this.firstEdge) * (p - this.secondEdge) * (p - this.thirdEdge));
        System.out.println(s);
    }

    public static void main(String[] args) {
        ExerciseTriangle t = new ExerciseTriangle();
        t.firstEdge = 30;
        t.secondEdge = 40;
        t.thirdEdge = 50;
        // 计算面积并在控制台输出面积
        t.squaring();
    }

}
