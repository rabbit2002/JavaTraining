package javaOop.chapter07_OrderSystem;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * ATM管理系统
 * 数据定义
 * - 1.基本信息
 * -   1.1.姓名           String[]  accountName
 * -   1.2.账户名         String[]  accountNumber
 * -   1.3.密码           String[]  accountPassword
 * -   1.4.账户余额       double[]  accountAmount
 * - 2.系统日志
 * -   2.1.系统信息       String[]  systemLog
 * - 3.其他信息
 * -   3.1.账户最大保存上限 int      ACCOUNT_MAX
 * -   3.2.系统日志最大保存上限 int   LOGS_MAX
 * -   3.3.当前账户数量    int       pointAccount
 * -   3.4.当前日志数量    int       pointLogs
 * -   3.5.是否插卡       boolean   isHaveCard
 * -   3.5.当前操作账户下标int       pointIndex
 * <p>
 * 主要功能
 * - 1.未插卡
 * -   1.1.开户
 * -     1.1.1.姓名
 * -     1.1.2.账户名(手机号)
 * -     1.1.3.设置密码
 * -   1.2.插卡
 * - 2.插卡
 * -   2.1.存钱 deposit
 * -     2.1.1.日志记录
 * -   2.2.取钱 withdraw
 * -     2.2.1.日志记录
 * -   2.3.更新用户信息
 * -     2.3.1.姓名
 * -     2.3.2.账户名(手机号)
 * -     2.3.3.设置密码
 * -   2.4.销户
 * -     2.4.1.确认密码
 * -   2.5.退卡
 * - 3.查看日志
 *
 * @author RABBIT2002
 * @date 2020/12/4
 */
public class AtmSystem {
    /**
     * 账户最大保存上限
     */
    private static final int ACCOUNT_MAX = 10;
    /**
     * 系统日志最大保存上限
     */
    private static final int LOGS_MAX = 1000;
    /**
     * 姓名
     */
    private static String[] accountName;
    /**
     * 账户名
     */
    private static String[] accountNumber;
    /**
     * 密码
     */
    private static String[] accountPassword;
    /**
     * 账户余额
     */
    private static double[] accountAmount;

    /**
     * 系统日志
     */
    private static String[] systemLog;

    /**
     * 当前账户总数
     */
    private static int pointAccount;
    /**
     * 当前日志总数
     */
    private static int pointLogs;
    /**
     * 当前操作账户下标
     */
    private static int pointIndex;

    private static Scanner scanner;
    private static Date date;
    private static SimpleDateFormat simpleDateFormat;

    /**
     * 初始化
     */
    public static void init() {
        // 初始化姓名数组
        accountName = new String[ACCOUNT_MAX];
        // 初始化账户名数组
        accountNumber = new String[ACCOUNT_MAX];
        // 初始化密码数组
        accountPassword = new String[ACCOUNT_MAX];
        // 初始化账户余额数组
        accountAmount = new double[ACCOUNT_MAX];

        // 初始化系统日志数组
        systemLog = new String[LOGS_MAX];

        // 初始化当前账户数量指针
        pointAccount = 0;
        // 初始化当前日志数量指针
        pointLogs = 0;
        // 当前操作账户下标
        pointIndex = -1;

        // 初始化Scanner对象
        scanner = new Scanner(System.in);
        date = new Date();
        simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.S");
    }

    /**
     * 菜单展示
     */
    public static void menuShow() {
        System.out.println("欢迎" + (pointIndex == -1 ? "" : accountName[pointIndex]) + "来到此ATM系统");
        System.out.println("--------------------");
        // 未插卡
        if (pointIndex == -1) {
            System.out.println("\t1.开户");
            System.out.println("\t2.插卡");
            System.out.println("\t9.查看日志记录");
        }
        // 插卡
        if (pointIndex >= 0) {
            displayBasicInfo();

            System.out.println("\t1.存钱");
            System.out.println("\t2.取钱");
            System.out.println("\t3.更新用户信息");
            System.out.println("\t4.销户");
            System.out.println("\t5.退卡");
            System.out.println("\t9.查看日志记录");
        }
        System.out.println("--------------------");
        System.out.println("请输入您的选择(键入数字,回车确定):");

        menuSelect();
    }

    /**
     * 菜单选择
     */
    public static void menuSelect() {
        if (pointIndex == -1) {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    login();
                    break;
                case 9:
                    showSystemLog();
                    break;
                default:
                    break;
            }
        } else if (pointIndex >= 0) {
            switch (Integer.parseInt(scanner.nextLine())) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    changeAccountInfo();
                    break;
                case 4:
                    deleteAccount();
                    break;
                case 5:
                    logout();
                    break;
                case 9:
                    showSystemLog();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * 存钱
     */
    public static void deposit() {
        System.out.println(accountName[pointIndex] + ",当前余额:" + accountAmount[pointIndex]);
        System.out.println("输入存款金额:");
        double money = Double.parseDouble(scanner.nextLine());
        accountAmount[pointIndex] += money;
        System.out.println("已存入:" + money);
        System.out.println(accountName[pointIndex] + ",当前余额:" + accountAmount[pointIndex]);
        insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 3, String.valueOf(money));
    }

    /**
     * 取钱
     */
    public static void withdraw() {
        System.out.println(accountName[pointIndex] + ",当前余额:" + accountAmount[pointIndex]);
        System.out.println("输入取款金额:");
        double money = Double.parseDouble(scanner.nextLine());
        if (money > accountAmount[pointIndex]) {
            System.out.println("余额不足!");
            insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 4, String.valueOf(money) + " Err");

            return;
        }
        accountAmount[pointIndex] -= money;
        System.out.println("已取出:" + money);
        System.out.println(accountName[pointIndex] + ",当前余额:" + accountAmount[pointIndex]);

        insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 4, String.valueOf(money));

        return;
    }

    /**
     * 修改用户信息
     */
    public static void changeAccountInfo() {
        displayBasicInfo();

        System.out.println("是否继续修改(Y-继续/任意键取消):");
        String temp = scanner.nextLine();
        if (!"Y".equals(temp.toUpperCase())) {
            System.out.println("已取消");
            return;
        }
        System.out.println("输入新姓名:");
        String username = scanner.nextLine();
        System.out.println("新姓名:" + username);

        System.out.println("输入新账户名:");
        String phoneNumber = scanner.nextLine();
        System.out.println("新账户名" + phoneNumber);

        String password = null;
        String passwordAgain = null;
        do {
            System.out.println("输入新密码");
            password = scanner.nextLine();
            System.out.println("再次输入新密码");
            passwordAgain = scanner.nextLine();
            if (!password.equals(passwordAgain)) {
                System.out.println("两次密码不一致,请重新输入");
            }
        } while (!password.equals(passwordAgain));

        AtmSystem.accountName[pointIndex] = username;
        AtmSystem.accountNumber[pointIndex] = phoneNumber;
        AtmSystem.accountPassword[pointIndex] = password;

        System.out.println("修改成功!");
        displayBasicInfo();

        int index = searchAccount(AtmSystem.accountNumber[pointIndex]);
        logout();
        insertSystemLog(AtmSystem.accountName[index], AtmSystem.accountNumber[index], 7, "success");
    }

    /**
     * 打印账户基本信息
     */
    public static void displayBasicInfo() {
        System.out.println("--------------------");
        System.out.println(accountName[pointIndex] + "您好,您的账户信息如下:");
        System.out.println("姓名:" + accountName[pointIndex]);
        System.out.println("账户名:" + accountNumber[pointIndex]);
        System.out.println("密码:" + (accountPassword[pointIndex].replaceAll("\\w", "*")));
        System.out.println("账户余额" + accountAmount[pointIndex]);
        System.out.println("--------------------");
    }

    /**
     * 创建账户
     */
    public static void createAccount() {
        System.out.println("创建账户");

        System.out.println("输入姓名:");
        String username = scanner.nextLine();
        System.out.println("姓名:" + username);
        System.out.println("输入账户名:");
        String phoneNumber = scanner.nextLine();
        System.out.println("账户名" + phoneNumber);

        String password = null;
        String passwordAgain = null;
        do {
            System.out.println("输入密码");
            password = scanner.nextLine();
            System.out.println("再次输入密码");
            passwordAgain = scanner.nextLine();
            if (!password.equals(passwordAgain)) {
                System.out.println("两次密码不一致,请重新输入");
            }
        } while (!password.equals(passwordAgain));

        AtmSystem.accountName[pointAccount] = username;
        AtmSystem.accountNumber[pointAccount] = phoneNumber;
        AtmSystem.accountPassword[pointAccount] = password;
        AtmSystem.accountAmount[pointAccount] = 0.0;

        pointIndex = pointAccount;
        pointAccount++;

        System.out.println(accountName[pointIndex] + "您好,您现在的信息如下:");
        System.out.println("姓名:" + accountName[pointIndex]);
        System.out.println("账户名:" + accountNumber[pointIndex]);
        System.out.println("密码:" + (accountPassword[pointIndex].replaceAll("\\w", "*")));

        insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 1, "success");
    }

    /**
     * 删除账户
     */
    public static void deleteAccount() {
        System.out.println("删除账户");

        String password = null;
        String passwordAgain = null;
        do {
            System.out.println("输入密码");
            password = scanner.nextLine();
            System.out.println("再次输入密码");
            passwordAgain = scanner.nextLine();
            if (!password.equals(passwordAgain)) {
                System.out.println("两次密码不一致,请重新输入");
            }
        } while (!password.equals(passwordAgain));

        if (accountAmount[pointIndex] > 0) {
            System.out.println("账户内仍有余额,不能销户");
            return;
        }

        int index = searchAccount(accountNumber[pointIndex]);

        logout();
        insertSystemLog(AtmSystem.accountName[index], AtmSystem.accountNumber[index], 2, "success");

        if (index != pointAccount) {
            for (int i = index; i < pointAccount - 1; i++) {
                accountName[i] = accountName[i + 1];
                accountNumber[i] = accountNumber[i + 1];
                accountPassword[i] = accountPassword[i + 1];
                accountAmount[i] = accountAmount[i + 1];
            }
        }
        pointAccount--;

    }

    /**
     * 登录
     */
    public static void login() {
        System.out.println("登录账户");

        System.out.println("请输入账户名");
        String accountNumber = scanner.nextLine();
        if (searchAccount(accountNumber) == -1) {
            System.out.println("该账户不存在");
            return;
        }
        System.out.println("请输入密码");
        String accountPassword = scanner.nextLine();

        pointIndex = searchAccount(accountNumber, accountPassword);
        if (pointIndex >= 0) {
            System.out.println("成功登录");
            insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 5, "success");
            return;
        } else {
            System.out.println("密码错误");
            insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 5, "pwd err");
            pointIndex = -1;
            return;
        }
    }

    /**
     * 登出
     */
    public static void logout() {
        System.out.println("已成功登出");
        insertSystemLog(AtmSystem.accountName[pointIndex], AtmSystem.accountNumber[pointIndex], 6, "success");
        pointIndex = -1;
    }

    /**
     * 插入日志
     *
     * @param accountName   :姓名
     * @param accountNumber :账户名
     * @param action        :行为 1.开户 2.销户 3.存钱 4.取钱 5.登录 6.登出 7.修改用户信息
     * @param remarks       :备注
     */
    public static void insertSystemLog(String accountName, String accountNumber, int action, String remarks) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(simpleDateFormat.format(date)).append("\t|");
        stringBuffer.append(accountName).append("\t|");
        stringBuffer.append(accountNumber).append("\t|");
        switch (action) {
            case 1:
                stringBuffer.append("create\t|");
                break;
            case 2:
                stringBuffer.append("close\t|");
                break;
            case 3:
                stringBuffer.append("deposit\t|");
                break;
            case 4:
                stringBuffer.append("withdraw\t|");
                break;
            case 5:
                stringBuffer.append("login\t|");
                break;
            case 6:
                stringBuffer.append("logout\t|");
                break;
            case 7:
                stringBuffer.append("alterIfo\t|");
                break;
            default:
                stringBuffer.append("others\t|");
                break;
        }
        stringBuffer.append(remarks);

        systemLog[pointLogs] = stringBuffer.toString();
        pointLogs++;
    }

    /**
     * 显示日志
     */
    public static void showSystemLog() {
        System.out.printf("index\t|\t\t\tTime\t\t\t|\tAccount\t|\tName\t|\tAction\t|\tRemarks\t|\n");
        for (int i = 0; i < pointLogs; i++) {
            System.out.printf("%8d|%s|\n", i + 1, systemLog[i]);
        }
    }

    /**
     * 通过账户名搜索账户索引
     *
     * @param accountNumber 账户名
     *
     * @return int 索引
     */
    public static int searchAccount(String accountNumber) {
        for (int i = 0; i < pointAccount; i++) {
            if (AtmSystem.accountNumber[i].equals(accountNumber)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 通过账户名及密码搜索账户索引
     *
     * @param accountNumber   账户名
     * @param accountPassword 密码
     *
     * @return int 索引
     */
    public static int searchAccount(String accountNumber, String accountPassword) {
        int index = searchAccount(accountNumber);
        if (index == -1) {
            return -1;
        }
        if (AtmSystem.accountPassword[index].equals(accountPassword)) {
            return index;
        }
        return -2;
    }

    public static void main(String[] args) {
        init();
        // showSystemLog();

        while (true) {
            menuShow();
        }
    }
}
