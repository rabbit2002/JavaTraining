package classobject;

import java.util.Arrays;

/**
 * Object 类
 * // TODO 完善
 *
 * String 是 s的 编译时类型
 * String s = null;
 * s.getClass() 获得引用变量 s 的 运行时类型
 * aClass.getName(); 获取类名
 * aClass.getSuperclass(); 获取直接父类
 * aClass.getInterfaces(); 获取实现的接口
 *
 * @author RABBIT2002
 * @date 2020/12/29
 */
public class ObjectClass {
    public static void main(String[] args) {
        String s = new String();
        Class aClass= s.getClass();
        System.out.println(aClass.getName());
        System.out.println(aClass.getSuperclass());
        System.out.println(Arrays.toString(aClass.getInterfaces()));
    }
}
