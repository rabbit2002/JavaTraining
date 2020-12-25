package charsequence.util;

import java.lang.reflect.Field;

/**
 * 分析 StringBuffer 构成
 *
 * @author RABBIT2002
 * @date 2020/12/25
 */
public class StringBufferHelper {
    private static Class<?> clazz;
    private static Field valueField;

    static {
        clazz = StringBuffer.class; // 通过 .class 属性获得任意类型对应的 Class实例
        // System.out.println(clazz);
        clazz = clazz.getSuperclass(); // 取 clazz 所表示的类的父类
        // System.out.println(clazz);
        try {
            valueField = clazz.getDeclaredField("value");
            valueField.setAccessible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void show(StringBuffer buffer) {
        if (buffer == null) {
            throw new NullPointerException("不可以这样子哦"); // NPE : NullPointerException
        }
        try {
            System.out.print("capacity : " + buffer.capacity());
            System.out.print(" , length : " + buffer.length());
            System.out.println(" , value : " + valueField.get(buffer));
            System.out.println("缓冲区中的内容 : " + buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
