import java.util.HashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * description TODO
 *
 * @author RABBIT2002
 * @date 2021/1/9
 */
public class Test {
    public static void main(String[] args) {

        // https://blog.csdn.net/qq_16605855/article/details/78387629
        // 静态导入 gc  NumberFormat

        int c = 10;
        Count count =new Count() {
            @Override
            public int add(int a, int b) {
                // Variable 'c' is accessed from within inner class, needs to be final or effectively final
                int sum=a+b+c;
                return c;
            }
        };
         // c=30;
         System.out.println(count.add(10,20));

        String s="null";
        switch (s) {
            case "A" : break;
            case "儿女" : break;
            case "农丰" : break;
            default :
        }//switch
    }
}

interface Count {
    int add(int a, int b);
}
