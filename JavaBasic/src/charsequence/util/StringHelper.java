package charsequence.util;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Objects;

/**
 * 分析 String 构成
 *
 * @author RABBIT2002
 * @date 2020/12/24
 */
public class StringHelper {

    public static void analysis(final String s) {
        if (Objects.isNull(s)) {
            throw new IllegalArgumentException("不可以为null哦");
        }

        Class<?> stringClass = s.getClass();

        try {
            Field valueField = stringClass.getDeclaredField("value");
            Field coderField = stringClass.getDeclaredField("coder");
            Field hashField = stringClass.getDeclaredField("hash");

            valueField.setAccessible(true);
            coderField.setAccessible(true);
            hashField.setAccessible(true);

            Object value = valueField.get(s);
            Object coder = coderField.get(s);
            Object hash = hashField.get(s);

            byte[] bytes = (byte[])value;

            System.out.println("value = " + value + " , coder = " + coder + " , hash = " + hash);
            System.out.println("value : " + Arrays.toString(bytes));

            System.out.println("identityHashCode: " + System.identityHashCode(s));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void set(final String s, int byteIndex, byte byteValue) {
        if (Objects.isNull(s)) {
            throw new IllegalArgumentException("不可以为null哦");
        }

        Class<?> stringClass = s.getClass();

        try {
            Field valueField = stringClass.getDeclaredField("value");
            valueField.setAccessible(true);
            Object value = valueField.get(s);
            Array.set(value, byteIndex, byteValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
