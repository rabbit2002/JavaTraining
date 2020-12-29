package comparingobjects;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Arrays.sort(); 提供了对一个数组进行排序的方法
 * 在使用sort()排序时, 需要比较两个元素的大小,
 * 1. 则需要该实例的类实现 Comparable接口 的 compareTo方法
 * 2. 或者使用 Comparator比较器
 *
 * @author RABBIT2002
 * @date 2020/12/28
 */
public class ArraysSortClass {
    public static void main(String[] args) {
        func2();
    }

    private static void func1() {
        Animal[] animals = new Animal[10];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0, x = 65; i < animals.length; i++, x++) {
            animals[i] = new Animal(random.nextInt(100), (char)(random.nextInt(24) + 65) + "");
        }
        System.out.println(Arrays.toString(animals));

        Arrays.sort(animals);
        System.out.println(Arrays.toString(animals));
    }

    private static void func2() {
        Animal[] animals = new Animal[10];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < animals.length; i++) {
            animals[i] = new Animal(random.nextInt(100), (char)(random.nextInt(24) + 65) + "");
        }
        System.out.println(Arrays.toString(animals));

        Comparator comparator = new Comparator<Animal>() {
            @Override
            public int compare(Animal o1, Animal o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Arrays.sort(animals, comparator);
        System.out.println(Arrays.toString(animals));
    }
}
