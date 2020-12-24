package exercise.method;

import java.util.Random;

/**
 * 训练题-参数传递
 *
 * @author RABBIT2002
 * @date 2020/12/23
 */
public class Exercise01 {

    public static void main(String[] args) {
        Exercise01 exercise01 = new Exercise01();
        Random random = new Random(System.currentTimeMillis());

        int[] testArray = null;
        exercise01.traversal(testArray);

        testArray = new int[0];
        exercise01.traversal(testArray);

        testArray = new int[10];
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = random.nextInt(Integer.MAX_VALUE);
        }
        exercise01.traversal(testArray);

        int[] a = {1, 100, -20, 99, 1000, 0, 30};
        System.out.print("排序前 : ");
        exercise01.traversal(a); // 排序前 : 1 , 100 , -20 , 99 , 1000 , 0 , 30

        exercise01.sort(a);
        System.out.print("排序后 : ");
        exercise01.traversal(a); // 排序后 : -20 , 0 , 1 , 30 , 99 , 100 , 1000

    }

    public void traversal(int[] array) {
        if (array == null) {
            System.out.println("Array is null");
            return;
        }
        if (array.length == 0) {
            System.out.println("Array's length is 0");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            System.out.print(i < array.length - 1 ? ", " : "");
        }
        System.out.println();
    }

    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
