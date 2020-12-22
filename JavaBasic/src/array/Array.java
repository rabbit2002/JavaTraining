package array;

import java.util.Arrays;

/**
 * 1.数组常量(array constants)
 * {1, 2, 3} 等这种被称为数组常量
 * <p>
 * 2.数组初始化分为 静态初始化 和 动态初始化
 * 2.1.静态初始化: 声明数组变量 和 数组中各元素初始化赋值是在一起的
 * int[] array = {1, 3, 5, 7, 9};
 * 数组声明过程:
 * 1.堆内存开辟内存空间
 * 2.数组常量对数组进行初始化
 * 3.堆内存中数组首地址赋值给变量
 * 2.2.动态初始化: 声明数组 创建数组 为数组个元素赋值 是分开的
 * 使用 new 关键字 显式创建数组后再用 数组常量 对数组各位置进行初始化
 * int[] array;
 * array = new int[] {1, 3, 5, 7, 9};
 * 数组声明过程:
 * 1.声明一个 int[] 类型的 array 变量
 * 2.在 堆内存中 创建 int 数组 并为各位置赋予默认值0
 * 3.将堆内存中的数组首地址赋值给 array 变量
 * <p>
 * 但如果声明数组后没有立即初始化赋值,则不能使用静态初始化,只能使用动态初始化
 * String[] strings;
 * // Array initializer is not allowed here, Array constants can only be used in initializers
 * // strings = {"1", "2"};
 * strings = new String[]{""};
 * <p>
 * https://stackoverflow.com/questions/10520617/why-can-array-constants-only-be-used-in-initializers/10520659#10520659
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class Array {
    public static void main(String[] args) {

        int[] array = {1, 3, 5, 7, 9};
        // 直接打印等于调用toString()
        System.out.println(array);
        System.out.println(array.toString());

        // 打印Object中原始hashcode
        System.out.println(System.identityHashCode(array));
        // 通过计算得到的hashcode,发现和直接toString一样
        System.out.println(Integer.toHexString(System.identityHashCode(array)));

        System.out.println(Arrays.toString(array));
    }
}
