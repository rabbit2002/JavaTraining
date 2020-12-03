package javaOop.chapter07_OrderSystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 订餐系统
 * <p>
 * 数据定义
 * - 1.菜品信息
 * -   1.1.餐品名称    String[]  foodName
 * -   1.2.餐品价格    double[]  foodPrices
 * -   1.3.点赞情况    int[]     foodComment
 * - 2.订餐信息
 * -   2.1.订餐人姓名  String[]  orderUserName
 * -   2.2.订餐餐品    int[]     OrderFood
 * -   2.3.订餐数量    int[]     orderCount
 * -   2.4.送餐时间    byte[]    orderTime
 * -   2.5.送餐地址    String[]  orderAddress
 * -   2.6.订餐总价格  double[]  orderPrice
 * -   2.7.订单签收    boolean[] orderConfirm
 * <p>
 * 主要功能
 * - 0.主菜单       main
 * - 1.开始订餐     addOrder
 * -   1.1.展示所有餐品    showAllFood
 * -   1.2.选择餐品序号并合法性验证
 * -   1.3.输入信息
 * -     1.3.1.订餐人姓名
 * -     1.3.2.订餐数量
 * -     1.3.3.送餐时间
 * -       1.3.3.1.限定条件
 * -     1.3.4.送餐地址
 * -     1.3.5.订餐总价格
 * -       1.3.5.1.总价格大于50元免费送餐
 * -     1.3.5.2.总价格小于50元付5元送餐费
 * - 2.查看订餐     showOrderAll
 * -   2.1.订餐人姓名
 * -   2.2.订餐餐品
 * -   2.3.订餐数量
 * -   2.4.送餐时间
 * -   2.5.送餐地址
 * -   2.6.总金额
 * -   2.7.订单签收状态
 * - 3.签收订单     confirmOrder
 * -   3.1.已签收
 * -     3.1.1.不允许重复签收
 * -   3.2.未签收
 * - 4.删除订单     deleteOrder
 * - 5.餐品点赞     commentFood
 * - 6.退出系统     exitSystem
 *
 * @author RABBIT2002
 * @date 2020/12/3
 */
public class OrderSystem {
    /**
     * 餐品数量定义
     */
    private static final int FOOD_COUNT_MAX = 3;
    /**
     * 订单数量定义
     */
    private static final int ORDER_COUNT_MAX = 5;
    /**
     * 送餐限定时间开始 0-24
     */
    private static final byte TIME_START = 0;
    /**
     * 送餐限定时间结束 0-24
     */
    private static final byte TIME_END = 24;
    /**
     * 配送费免除阈值
     */
    private static final double EXTRA_PRICE_THRESHOLD = 35;
    /**
     * 配送费价格
     */
    private static final double EXTRA_PRICE = 10;

    /**
     * 餐品名称
     */
    private static String[] foodName;
    /**
     * 餐品价格
     */
    private static double[] foodPrices;
    /**
     * 点赞情况
     */
    private static int[] foodComment;

    /**
     * 订餐人姓名
     */
    private static String[] orderUserName;
    /**
     * 订餐餐品
     */
    private static int[] orderFood;
    /**
     * 订餐数量
     */
    private static int[] orderCount;
    /**
     * 送餐时间
     */
    private static byte[] orderTime;
    /**
     * 送餐地址
     */
    private static String[] orderAddress;
    /**
     * 订餐总价格
     */
    private static double[] orderPrice;
    /**
     * 订单签收 true=签收 false=未签收
     */
    private static boolean[] orderConfirm;

    /**
     * 当前订单指针
     */
    private static int point;

    private static Scanner scanner = null;

    /**
     * 初始化
     */
    public static void init() {
        // 初始化餐品
        foodName = new String[]{"番茄炒蛋", "鱼香茄子", "京酱肉丝"};
        foodPrices = new double[]{21.23, 32.34, 43.45};
        foodComment = new int[FOOD_COUNT_MAX];
        // 初始化订单
        orderUserName = new String[ORDER_COUNT_MAX];
        orderFood = new int[ORDER_COUNT_MAX];
        orderCount = new int[ORDER_COUNT_MAX];
        orderTime = new byte[ORDER_COUNT_MAX];
        orderAddress = new String[ORDER_COUNT_MAX];
        orderPrice = new double[ORDER_COUNT_MAX];
        orderConfirm = new boolean[ORDER_COUNT_MAX];

        // 初始化Scanner实例
        scanner = new Scanner(System.in);
        // 初始化订单总数指针
        point = 0;

        // 添加模拟测试数据
        {
            foodComment[0] = 45;
            foodComment[1] = 32;
            foodComment[2] = 67;
        }
        {
            orderUserName[point] = "123ABC";
            orderFood[point] = 0;
            orderCount[point] = 5;
            orderTime[point] = 10;
            orderAddress[point] = "123ABC";
            orderPrice[point] = 123.456;
            orderConfirm[point] = false;
            point++;
        }
        {
            orderUserName[point] = "456DEF";
            orderFood[point] = 1;
            orderCount[point] = 10;
            orderTime[point] = 20;
            orderAddress[point] = "456DEF";
            orderPrice[point] = 456.789;
            orderConfirm[point] = true;
            point++;
        }
        {
            orderUserName[point] = "789HIG";
            orderFood[point] = 2;
            orderCount[point] = 20;
            orderTime[point] = 30;
            orderAddress[point] = "789HIG";
            orderPrice[point] = 321.654;
            orderConfirm[point] = true;
            point++;
        }
    }

    /**
     * 显示菜单
     */
    public static void menuShow() {
        System.out.println("欢迎来到此订单系统");
        System.out.println("--------------------");
        System.out.println("\t1.开始订餐");
        System.out.println("\t2.查看订餐");
        System.out.println("\t3.签收订单");
        System.out.println("\t4.删除订单");
        System.out.println("\t5.餐品点赞");
        System.out.println("\t0.退出系统");
        System.out.println("--------------------");
        System.out.println("请进行你的选择(键入数字,回车确定):");

        menuSelect();
    }

    /**
     * 选择菜单
     */
    public static void menuSelect() {
        switch (Integer.parseInt(scanner.nextLine())) {
            case 0:
                System.out.println("欢迎您的使用!");
                System.out.println("Powered by RABBIT2002(Ayano Yuki)");
                System.out.println("2020.12.03");
                anyKeyToContinue();
                System.exit(0);
                break;
            case 1:
                addOrder();
                break;
            case 2:
                showOrderAll();
                anyKeyToContinue();
                break;
            case 3:
                confirmOrder();
                break;
            case 4:
                deleteOrder();
                break;
            case 5:
                commentFood();
                break;
            default:
                System.out.println("您的输入有误,请重新输入!");
                anyKeyToContinue();
                break;
        }
    }

    /**
     * 展示所有餐品信息
     */
    public static void showAllFood() {
        System.out.println("以下是所有餐品信息:");
        System.out.println("※\t餐品名称\t\t餐品价格\t\t点赞情况");
        for (int i = 0; i < FOOD_COUNT_MAX; i++) {
            System.out.printf("%d\t%s\t\t￥%.2f\t\t%d\n", i + 1, foodName[i], foodPrices[i], foodComment[i]);
        }
    }

    /**
     * 开始订餐
     */
    public static void addOrder() {
        clearConsole();
        System.out.println("----1.开始订餐----");

        // 订餐人姓名
        String tempName = null;
        // 选择餐品
        int tempFoodSelect = 0;
        // 订餐数量
        int tempCount = 0;
        // 送餐时间
        byte tempTime = 0;
        // 送餐地址
        String tempAddress = null;
        // 订餐总价
        double tempPrice = 0.0;

        // 确认订单无误Flag
        String tempFlagConfirm = null;
        // 确认继续购买Flag
        String tempFlagAgain = null;

        if (point >= ORDER_COUNT_MAX) {
            System.out.println("很抱歉,当前系统订单总数已满,请删除多余废弃订单后重试!");
            anyKeyToContinue();
            return;
        }

        do {
            do {
                System.out.println("请输入订餐人姓名:");
                tempName = scanner.nextLine().trim();
                System.out.println(tempName + "欢迎您:");

                showAllFood();

                double tempFoodPrice = 0.0;
                double tempPackingPrice = 0.0;
                String inputFlag = null;
                do {
                    System.out.println(tempName + " 您好!请选择您想点的餐品(键入数字(" + 1 + "-" + FOOD_COUNT_MAX + ",0取消),回车确定):");
                    // System.out.printf("%s您好!请选择您想点的餐品(键入数字(%d-%d,0-取消),回车确定):\n", tempName, 1, FOOD_COUNT_MAX);
                    tempFoodSelect = Integer.parseInt(scanner.nextLine());
                    while (tempFoodSelect < 0 || tempFoodSelect > FOOD_COUNT_MAX) {
                        System.out.println("输入错误,请在范围内重新输入(" + 0 + "-" + FOOD_COUNT_MAX + ")");
                        tempFoodSelect = Integer.parseInt(scanner.nextLine());
                    }
                    if (tempFoodSelect == 0) {
                        System.out.println("您已退出订餐页面!");
                        anyKeyToContinue();
                        return;
                    }
                    System.out.println(tempName + " 您好!您选择了: " + foodName[tempFoodSelect - 1]);

                    System.out.println("请输入订餐数量(温馨提示:订餐总价小于" + EXTRA_PRICE_THRESHOLD + "元时,需要支付" + EXTRA_PRICE + "元配送费!):");
                    tempCount = Integer.parseInt(scanner.nextLine());
                    tempFoodPrice = foodPrices[tempFoodSelect - 1] * tempCount;
                    tempPackingPrice = (foodPrices[tempFoodSelect - 1] * tempCount < EXTRA_PRICE_THRESHOLD) ? EXTRA_PRICE : 0;
                    tempPrice = tempFoodPrice + tempPackingPrice;

                    System.out.println(tempName + "您好!您选择了:" + tempCount + "份" + foodName[tempFoodSelect - 1] + ","
                            + "小计:" + foodPrices[tempFoodSelect - 1] * tempCount + "元,需要" + tempPackingPrice + "元配送费,"
                            + "共计:" + tempPrice + "元");
                    System.out.println("您是否重新选择产品及数量?(Y-确认/任意键-继续)");
                    inputFlag = scanner.nextLine().trim().toUpperCase();
                } while ("Y".equals(inputFlag));

                System.out.println("请选择您的送餐时间(" + TIME_START + "时至" + TIME_END + "时):");
                tempTime = Byte.parseByte(scanner.nextLine());
                while (tempTime < TIME_START || tempTime > TIME_END) {
                    System.out.println("输入错误,请在范围内重新输入(" + TIME_START + "-" + TIME_END + ")");
                    tempTime = Byte.parseByte(scanner.nextLine());
                }
                System.out.println(tempName + "您好!您的:" + tempCount + "份" + foodName[tempFoodSelect - 1]
                        + "将于" + tempTime + " 时,为您配送");

                System.out.println("请输入您的送餐地址:");
                tempAddress = scanner.nextLine();

                System.out.println("--------------------");
                System.out.println(tempName + "您好,请确认您的订单:");
                System.out.println("您选择了" + tempCount + "份" + foodName[tempFoodSelect - 1] + ","
                        + "共计" + tempPrice + "元,将于" + tempTime + "时为您配送至" + tempAddress);

                System.out.println("是否确认无误?(任意键-确认/N-重新填写)");
                tempFlagConfirm = scanner.nextLine().trim().toUpperCase();
            } while ("N".equals(tempFlagConfirm));

            orderUserName[point] = tempName;
            // 选择餐品
            orderFood[point] = tempFoodSelect - 1;
            // 订餐数量
            orderCount[point] = tempCount;
            // 送餐时间
            orderTime[point] = tempTime;
            // 送餐地址
            orderAddress[point] = tempAddress;
            // 订餐总价格
            orderPrice[point] = tempPrice;
            // 初始化签收状态
            orderConfirm[point] = false;
            point++;

            showOrderNow();

            System.out.println("该订单已完成,是否继续订餐?(Y-继续/任意键-取消)");
            tempFlagAgain = scanner.nextLine().trim().toUpperCase();
        } while ("Y".equals(tempFlagAgain));
    }

    /**
     * 显示最新订单
     */
    public static void showOrderNow() {
        System.out.println("以下是当前订单信息:");
        showOrder(point - 1, point);
    }

    /**
     * 显示订单
     */
    public static void showOrder(int start, int end) {
        for (int i = start; i < end; i++) {
            System.out.println("订单编号:\t" + (i + 1));
            System.out.println("\t订餐人姓名:\t" + orderUserName[i]);
            System.out.println("\t订餐餐品:\t" + foodName[orderFood[i]]);
            System.out.println("\t订餐数量:\t" + orderCount[i]);
            System.out.printf("\t订单金额:\t￥%.2f\n", orderPrice[i]);
            System.out.println("\t送餐时间:\t" + orderTime[i]);
            System.out.println("\t送餐地址:\t" + orderAddress[i]);
            System.out.println("\t订单签收状态:" + (orderConfirm[i] == true ? "是" : "否"));
        }
    }

    /**
     * 显示所有订单
     */
    public static void showOrderAll() {
        clearConsole();
        System.out.println("----2.查看订餐----");

        if (point > 0) {
            System.out.println("以下是所有订单信息:");
            showOrder(0, point);
        } else {
            System.out.println("当前并无订单!");
        }
    }

    /**
     * 检索确认的订单
     *
     * @return 确认的订单编号组 0-arrayListTrue 1-arrayListFalse
     */
    public static ArrayList<Integer>[] checkOrderConfirm() {
        ArrayList<Integer> arrayListTrue = new ArrayList<>();
        ArrayList<Integer> arrayListFalse = new ArrayList<>();
        for (int i = 0; i < point; i++) {
            if (orderConfirm[i]) {
                arrayListTrue.add(i);
            } else {
                arrayListFalse.add(i);
            }
        }
        return new ArrayList[]{arrayListTrue, arrayListFalse};
    }

    public static boolean judgeExist(int number, ArrayList<Integer> numberArr) {
        for (int i = 0; i < numberArr.size(); i++) {
            System.out.println(numberArr.get(i));
            if (number == numberArr.get(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 签收订单
     */
    public static void confirmOrder() {
        clearConsole();
        System.out.println("----3.签收订单----");

        if (point == 0) {
            System.out.println("当前没有订单,不能确认!");
            anyKeyToContinue();
            return;
        }
        ArrayList<Integer> confirmNotOrderList = checkOrderConfirm()[1];
        if (confirmNotOrderList.size() == 0) {
            System.out.println("当前所有订单均已确认,无需再次确认!");
            showOrderAll();
            anyKeyToContinue();
            return;
        }

        String tempFlag = null;
        do {
            showOrderAll();
            int number = 0;
            do {
                System.out.print("请选择您要签收的订单(0-取消");
                for (int i : confirmNotOrderList) {
                    System.out.print(" " + (i + 1) + "-确认");
                }
                System.out.println("):");

                number = Integer.parseInt(scanner.nextLine());
                if (number == 0) {
                    System.out.println("您已取消签收!");
                    anyKeyToContinue();
                    return;
                }

                if (orderConfirm[number - 1]) {
                    System.out.println("该订单已经签收,不允许重复签收,请重新选择!");
                    System.out.println("请选择您要签收的订单编号:");
                }
            } while (orderConfirm[number - 1]);
            orderConfirm[number - 1] = true;

            confirmNotOrderList = checkOrderConfirm()[1];
            if (confirmNotOrderList.size() == 0) {
                System.out.println("当前所有订单均已确认,无需再次确认!");
                showOrderAll();
                anyKeyToContinue();
                return;
            }
            System.out.println("还需要签收吗？(任意键-取消/Y-继续)");
            tempFlag = scanner.nextLine().trim().toUpperCase();
        } while ("Y".equals(tempFlag));

    }

    /**
     * 删除订单
     */
    public static void deleteOrder() {
        clearConsole();
        System.out.println("----4.删除订单----");

        String tempFlag = null;
        do {
            if (point == 0) {
                System.out.println("当前没有订单,不能删除!");
                anyKeyToContinue();
                return;
            }
            ArrayList<Integer> confirmOrderList = checkOrderConfirm()[0];
            if (confirmOrderList.size() == 0) {
                System.out.println("当前所有订单均未确认,不能删除!");
                showOrderAll();
                anyKeyToContinue();
                return;
            }
            showOrderAll();
            int number = 0;
            do {
                System.out.print("请选择要删除的订单(0-取消");
                for (int i : confirmOrderList) {
                    System.out.print(" " + (i + 1) + "-删除");
                }
                System.out.println("):");

                number = Integer.parseInt(scanner.nextLine());
                if (number == 0) {
                    System.out.println("您已取消删除!");
                    anyKeyToContinue();
                    return;
                }
                if (number < 0 || number > point || !judgeExist(number - 1, confirmOrderList)) {
                    System.out.println("当前输入不正确,请重新输入!");
                }
            } while (number < 0 || number > point || !judgeExist(number - 1, confirmOrderList));

            if (!orderConfirm[number - 1]) {
                System.out.println("当前订单未确认签收,不能删除!");
            } else {
                if (number != point) {
                    for (int i = number - 1; i < point - 1; i++) {
                        orderUserName[i] = orderUserName[i + 1];
                        orderFood[i] = orderFood[i + 1];
                        orderCount[i] = orderCount[i + 1];
                        orderTime[i] = orderTime[i + 1];
                        orderAddress[i] = orderAddress[i + 1];
                        orderPrice[i] = orderPrice[i + 1];
                        orderConfirm[i] = orderConfirm[i + 1];
                    }
                }
                point--;
                System.out.println("已成功删除!");
            }

            System.out.println("还需要继续删除吗？(任意键-取消/Y-继续)");
            tempFlag = scanner.nextLine().trim().toUpperCase();
        } while ("Y".equals(tempFlag));
    }

    /**
     * 点赞食物
     */
    public static void commentFood() {
        clearConsole();
        System.out.println("----5.餐品点赞----");

        String tempFlag = null;
        do {
            showAllFood();

            System.out.println("请选择您要点赞的餐品序号(0-取消 1-" + FOOD_COUNT_MAX + "-选择):");
            int tempNumber = 0;
            tempNumber = Integer.parseInt(scanner.nextLine());

            if (tempNumber == 0) {
                return;
            }
            System.out.println("请输入您要点赞" + foodName[tempNumber - 1] + "餐品的赞数(0-10,不输入或超过均默认10)");
            int tempCount = 0;
            try {
                tempCount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception) {
                tempCount = 0;
            }
            tempCount = tempCount == 0 || tempCount > 10 ? 10 : tempCount;
            foodComment[tempNumber - 1] += tempCount;
            System.out.println("您已给" + foodName[tempNumber - 1] + "点赞" + tempCount + "次");

            System.out.println("是否继续点赞?(任意键-返回/Y-继续)");
            tempFlag = scanner.nextLine().toUpperCase();
        }
        while ("Y".equals(tempFlag));
    }

    /**
     * 控制台清屏
     */
    public static void clearConsole() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    /**
     * 任意键继续
     */
    public static void anyKeyToContinue() {
        System.out.println("请按任意键继续!");
        scanner.nextLine();

        clearConsole();
    }

    public static void main(String[] args) {
        init();
        while (true) {
            try {
                clearConsole();
                menuShow();
            } catch (Exception exception) {
                System.out.println("您的输入值有误,请检查后重新输入!");
                anyKeyToContinue();
            }
        }
    }
}
