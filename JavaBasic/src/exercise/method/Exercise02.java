package exercise.method;

/**
 * 训练题-参数传递-采用自定义类型参数
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class Exercise02 {
    private String name;
    private char gender;
    private int age;
    private boolean married;

    public static void main(String[] args) {
        Exercise02 mine = new Exercise02();
        mine.name = "mine";
        mine.gender = '男';
        mine.age = 22;
        mine.married = false;

        Exercise02 another = new Exercise02();
        another.name = "another";
        another.gender = '女';
        another.age = 20;
        another.married = false;

        mine.marry(another);
    }

    /**
     * 判断自己 ( this ) 跟 另外一个人( another )结婚
     */
    public void marry(Exercise02 another) {
        if (this.married || another.married) {
            System.out.println("有人结过婚啦");
            return;
        }
        if (this.gender == another.gender) {
            System.out.println("现行中国法律不支持同性结婚");
            return;
        }
        if (this.gender == '男' && this.age < 22 || this.gender == '女' && this.age < 20) {
            System.out.println("自己年龄不够");
            return;
        }
        if (another.gender == '男' && another.age < 22 || another.gender == '女' && another.age < 20) {
            System.out.println("对方年龄不够");
            return;
        }
        System.out.println("自己和" + another.name + "结婚了");
    }

}
