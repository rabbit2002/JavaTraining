package JavaOop.Chapter04_Array;

import java.util.Arrays;

/**
 * 一个专门用来操作数组的类，提供了一系列方法用于操作数组
 * java.util.Arrays
 * <p>
 * //升序排序 使用快排实现
 * Arrays.sort(Object[] a);
 * // [fromIndex, toIndex-1)
 * Arrays.sort(Object[] a, int fromIndex, int toIndex);
 * <p>
 * // 为数组元素填充相同的值
 * Arrays.fill(Object[] a);
 * // [fromIndex, toIndex-1)
 * Arrays.fill(Object[] a, int fromIndex, int toIndex, Object val);
 * <p>
 * //对数组使用Lamda表达式填充
 * Arrays.setAll(T[] array, IntFunction<? extends T> generator);
 * <p>
 * // 返回字符串形式
 * Arrays.toString();
 * // 返回多维数组的字符串形式
 * Arrays.deepToString();
 * <p>
 * // 判断两个数组是否相等
 * // 指针相同、长度相等、元素也相同
 * Arrays.equals(Object[] a, Object[] b);
 * // [fromIndex, toIndex-1)
 * Arrays.equals(Object[] a, int aFromIndex, int aToIndex, Object[] b, int bFromIndex, int bToIndex);
 * <p>
 * // 范围内截取，超过范围填充默认值
 * Arrays.copyOf(T[] original, int newLength);
 * // [fromIndex, toIndex-1)
 * Arrays.copyOfRange(T[] original, int from, int to);
 * <p>
 * // 要求升序排列后操作，否则可能下标异常
 * // 找到，                从0开始，返回 index
 * // 未找到，在数组范围内，  从1开始，返回插入后 -index
 * // 未找到，大于数组内元素，从1开始，返回 -(length+1)
 * // 未找到，小于数组内元素，从1开始，返回 -1
 * Arrays.binarySearch(Object[] a, Object key);
 * Arrays.binarySearch(Object[] a, int fromIndex, int toIndex, Object key);
 * <p>
 * // 返回一个新java.util.Arrays.ArrayList
 * // 是Arrays类自己定义的一个静态内部类，这个内部类没有实现add()、remove()方法，
 * // 而是直接使用它的父类AbstractList的相应方法。
 * // 如果List只是用来遍历，就用Arrays.asList()。
 * // 如果List还要添加或删除元素，还是乖乖地new一个java.util.ArrayList，然后一个一个的添加元素。
 * Arrays.asList()
 *
 * @author RABBIT2002
 * @date 2020/11/30
 */
public class Array {
    public static void main(String[] args) {
        int[] arr1 = new int[]{3, 1, 2, 6, 4, 5};
        // [3, 1, 2, 6, 4, 5]
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr1);
        // [1, 2, 3, 4, 5, 6]
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{6, 5, 4, 3, 2, 1};
        Arrays.sort(arr1, 1, 4);
        // [6, 3, 4, 5, 2, 1]
        System.out.println(Arrays.toString(arr1));

        arr1 = new int[]{6, 5, 4, 3, 2, 1};
        Arrays.fill(arr1, 1, 4, 9);
        // [6, 9, 9, 9, 2, 1]
        System.out.println(Arrays.toString(arr1));

        int[] finalArr = arr1;
        Arrays.setAll(arr1, x -> finalArr[x] - 1);
        // [5, 8, 8, 8, 1, 0]
        System.out.println(Arrays.toString(finalArr));

        int[][] matrix = new int[][]{{3, 2, 1}, {6, 5, 4}};
        // [[I@58ceff1, [I@7c30a502]
        System.out.println(Arrays.toString(matrix));
        // [[3, 2, 1], [6, 5, 4]]
        System.out.println(Arrays.deepToString(matrix));

        arr1 = new int[]{6, 5, 4, 3, 2, 1};
        int[] arr2 = new int[]{5, 4, 3, 2};
        // false
        System.out.println(Arrays.equals(arr1, arr2));
        // true
        System.out.println(Arrays.equals(arr1, 1, 5, arr2, 0, 4));

        // [5, 4]
        System.out.println(Arrays.toString(Arrays.copyOf(arr2, 2)));
        // [5, 4, 3, 2, 0, 0]
        System.out.println(Arrays.toString(Arrays.copyOf(arr2, 6)));
        // [4, 3]
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr2, 1, 3)));

        arr1 = new int[]{8, 6, 4, 2};
        Arrays.sort(arr1);
        // [2, 4, 6, 8]
        System.out.println(Arrays.toString(arr1));
        // 1
        System.out.println(Arrays.binarySearch(arr1, 4));
        // -3
        System.out.println(Arrays.binarySearch(arr1, 5));
        // -5
        System.out.println(Arrays.binarySearch(arr1, 10));
        // -1
        System.out.println(Arrays.binarySearch(arr1, 0));
        // 1
        System.out.println(Arrays.binarySearch(arr1, 1, 3, 4));
        // -3
        System.out.println(Arrays.binarySearch(arr1, 1, 3, 5));
        // -4
        System.out.println(Arrays.binarySearch(arr1, 1, 3, 10));
        // -2
        System.out.println(Arrays.binarySearch(arr1, 1, 3, 0));

    }
}
