package enumeration;

import java.util.Arrays;

/**
 * Enum 枚举类型
 * <p>
 * 首先要了解 单例模式(Singleton pattern),
 * 目的是返回 一个类的 唯一实例
 * <p>
 * 那么, 与之相对应的还有一个多例模式(prototype pattern),
 * 目的是返回 一个类的 可控的有限多个实例
 * 能自我创建并管理自己的实例
 * <p>
 * 枚举类中第一个分号之前, 用于书写, 枚举常量
 * <p>
 * 枚举默认实现以下方法:
 * this.ordinal(); // 获取当前枚举常量的序号
 * this.name(); // 获取当前枚举常量的名字
 * 类方法:
 * values(); // 取得枚举类中的所有枚举常量
 * Season.valueOf(...); // 根据 枚举常量名称 来获取枚举常量
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class EnumClass {
    public static void main(String[] args) {
        Season[] seasons = Season.values();
        System.out.println(Arrays.toString(seasons));

        // 都可以获取枚举常量
        System.out.println(Season.valueOf("SPRING"));
        System.out.println(Season.SPRING);
    }
}

enum Season {
    // SPRING,
    // 等同于 public static final Season SPRING = new Season();
    // SPRING("春"),
    // 等同于 public static final Season SPRING = new Season("春");
    SPRING("春"),
    SUMMER("夏"),
    AUTUMN("秋"),
    WINTER("冬");

    // 可以声明自己的成员变量
    private String description;

    // 枚举中的所有构造方法都是私有的
    // 默认是无参构造
    Season() {
        // 不能显示调用父类构造方法
        // super();
    }

    // 可以定义有参构造
    Season(String description) {
        this.description = description;
    }

    // 可以声明自己的成员方法
    @Override
    public String toString() {
        return "Season{" + this.ordinal() + ", " + this.name() +
                ", description='" + description + "'}";
    }

}
