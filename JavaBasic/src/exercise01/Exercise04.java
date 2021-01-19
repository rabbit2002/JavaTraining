package exercise01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入单词 并排序
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise04 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sort(new String[]{"4","1","3","2"})));
    }

    private static String[] sort(String[] strings) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String s : strings) {
            arrayList.add(s);
        }
        arrayList.sort((o1, o2) -> o1.compareToIgnoreCase(o2));

        return arrayList.toArray(new String[0]);
    }
}
