package exercise.array;

/**
 * Exercise02
 *
 * @author RABBIT2002
 * @date 2020/12/22
 */
public class Exercise02 {
    public static void main(String[] args) {
        // 设 names 数组中存放学生姓名
        String[] names = {"雷军", "马云", "谭浩强", "佟瑶", "蓝馨怡"};
        // 设 courses 数组中依次存放三门课程的名称
        String[] courses = {"C++", "Java", "English"};
        // 设 scores 数组中依次存储的是 names 数组中各个学生的 C++ 、Java 、English 课程的成绩
        int[][] scores = {
                {90, 89, 75},
                {59, 40, 100},
                {100, 99, 80},
                {80, 61, 61},
                {60, 100, 99}
        };

        // 英语成绩降序排序
        // for (int i = 0; i < scores.length - 1; i++) {
        //     for (int j = 0; j < scores.length - 1 - i; j++) {
        //         int f = scores[j][2];
        //         int s = scores[j + 1][2];
        //         if (f < s) {
        //             int[] temp = scores[j];
        //             scores[j] = scores[j + 1];
        //             scores[j + 1] = temp;
        //             String x = names[j];
        //             names[j] = names[j + 1];
        //             names[j + 1] = x;
        //         }
        //     }
        // }

        // 总成绩降序排序
        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < scores.length - 1 - i; j++) {
                if (scores[j][0] + scores[j][1] + scores[j][2] < scores[j + 1][0] + scores[j + 1][1] + scores[j + 1][2]) {
                    int[] tempInt = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = tempInt;
                    String tempStr = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempStr;
                }
            }
        }

        for (int i = 0; i < scores.length; i++) {
            // 输出学生姓名
            System.out.print(names[i] + " => ");
            for (int j = 0; j < scores[i].length; j++) {
                // 输出课程名称
                System.out.print(courses[j] + ": ");
                // 输出课程成绩
                System.out.print(scores[i][j]);
                if (j < scores[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

    }
}
