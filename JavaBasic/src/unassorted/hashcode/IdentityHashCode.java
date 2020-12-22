package unassorted.hashcode;

import java.util.Arrays;

/**
 * System.identityHashCode
 * <p>
 * Object.hashcode() 会返回对象的 hashCode,为了提高 hashMap 的性能,可以当做是由对象内存地址计算而来
 * hashcode()可以为每个元素使用统一的计算方法计算其存储位置
 * // TODO 补充原文说明
 * hashcode() 同时可用于 equals() 判断
 * // TODO 补充 重写equals()
 * <p>
 * 子类继承 Object 类,可能会重写 Object 类中的 hashCode() 方法
 * 而为了取得 Object 类 hashcode() 生成的原始 hash code,可以通过 System.identityHashCode() 方法获得
 * System.identityHashCode(); 可以获得任意引用变量所指向的对象对应的类在重写Object的hashCode之前hashCode方法返回的值
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class IdentityHashCode {

    private int id;

    public IdentityHashCode(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        System.out.println("super hash code: " + super.hashCode());
        // 在 hashCode(); 重写后,怎么生成 hash code 完全看自己
        // null 在 Object 中的 hashcode() 返回值是 0
        final int prime = 11;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("super equals: " + super.equals(obj));
        // TODO null instanceof Object
        if (obj instanceof IdentityHashCode) {
            IdentityHashCode identityHashCode = (IdentityHashCode)obj;
            return this.id == identityHashCode.id;
        }
        return false;
    }

    // 含有 public static void main(String[] args) 方法的类被称做 启动类( launch class ) 或 主类( main class )
    // 当运行 启动类 时首先会启动一个 JVM进程 ( process )，JVM 进程内部会创建一个名称为 main 的线程 (thread)
    // 每个线程都私有地维护自己的方法栈
    // main线程 调用 StringTest1.main 方法并为其传入参数，同时会产生与该方法对应的 栈帧(stack frame)
    // 方法的参数 和 在方法内部 声明的变量 都属于 方法的局部变量，与方法的 栈帧有关
    // TODO 合并移动
    public static void main(String[] args) {
        // 等号之前的变量是存放在 main 方法的局部变量中
        // IdentityHashCode实例 存在于 堆
        IdentityHashCode identityHashCode1 = new IdentityHashCode(10);
        IdentityHashCode identityHashCode2 = new IdentityHashCode(10);
        // "String" 存在于 字符串常量池
        String s="String";

        System.out.println(identityHashCode1.hashCode());
        System.out.println("identityHashCode: " + System.identityHashCode(identityHashCode1));
        System.out.println(identityHashCode2.hashCode());
        System.out.println("identityHashCode: " + System.identityHashCode(identityHashCode2));

        System.out.println(identityHashCode1.equals(identityHashCode2));

        int[] array = {1, 3, 5, 7, 9};
        // 直接打印等于调用toString()
        System.out.println(array);
        System.out.println(array.toString());

        // 打印Object中原始hashcode
        System.out.println(System.identityHashCode(array));
        // 通过计算得到的hashcode,发现和直接toString一样
        System.out.println(Integer.toHexString(System.identityHashCode(array)));

        System.out.println(Arrays.toString(array));

        System.out.println(System.identityHashCode(null));
    }
}
