package chapter11_ExceptionHandling;

/**
 * Exception 异常: 程序在编译或者运行时发生的非正常现象,由程序抛出和处理
 * 当Exception捕获后需要被处理,当异常没有被处理程序就要终止,当异常处理后,程序继续运行
 * Error 错误: 仅靠程序本身无法恢复的严重错误(一般由虚拟机抛出),出现时应使程序安全退出
 * 在抛出异常时,会由系统自动创建异常链
 * <p>
 * 异常的体系结构:
 * . Object
 * . | Throwable
 * . L   (是异常体系结构的父类,子类分为Error与Exception)
 * .   | Error
 * .   L   (错误,无法通过开发人员编写程序解决的异常)
 * .     L E.g.VirtualMachineError/StackOverflowError/...
 * .   | Exception
 * .   L   (异常,可以通过开发人员编写程序解决的异常,是所有异常类的父类,分为编译时异常和运行时异常)
 * .     | 编译时异常/设计时异常/checked
 * .     L   (必须捕获,否则不能编译)
 * .       L E.g.ClassNotFoundException/...
 * .     | RuntimeException
 * .     L   (运行时异常/unchecked)
 * .       L E.g.NullPointerException/...
 * <p>
 * 异常处理
 * 1.捕获处理异常(try/catch/finally)
 * 1.1.使用
 * . try {
 * .   // 可能发生异常的代码
 * . } catch (Exception1 e) { // 异常捕获
 * .   // 异常1处理
 * . } catch (Exception2 e) {
 * .   // 异常2处理
 * . } finally {
 * .   // 最终处理
 * . }
 * 1.1.1.任何时间都要有try,后面必须要有catch或者finally
 * 1.1.2.catch或finally最少要有一个
 * 1.1.3.catch可以没有或者有多个,如果没有匹配的catch则向上抛出异常,catch的范围必须由子类到父类,同子类无关顺序
 * 1.1.4.finally可以没有或者有最多一个
 * 1.2.注意事项
 * 1.2.1.当异常发生后,程序会立刻进入与异常最近相匹配(类型一致或是发生异常的父类)的Catch块中,try中的代码不会继续执行
 * 1.2.2.当程序没有发生异常,程序不会执行catch块中的内容
 * 1.2.3.finally中的代码除非系统退出,否则无论如何都会执行
 * 1.2.3.1.当发生exception时,
 * 1.2.3.1.1.如果try有匹配的catch块,则执行顺序:try-exception-catch-finally-return回调
 * 1.2.3.1.1.如果try没有匹配的catch块,则执行顺序:try-exception-finally-throws
 * 1.2.3.1.当没有exception时,执行顺序:try-finally-return回调
 * <p>
 * 2.抛出异常(throw/throws)
 * 2.1.使用
 * . void func() throws Exception1, Exception2 { // 通知调用者
 * .   throw new Exception(); // 自行抛出异常
 * . }
 * 2.1.1.被调方法不处理异常,直接抛出给主调方法
 * 2.1.2.被调方法catch异常后再次抛给主调方法(用于修改异常信息)
 * .     E.g.catch(Exception e){throw new Exception(message)}
 * 2.2.注意事项
 * 对于运行时异常,当前没有捕获会自动throws,不需要写throws
 * <p>
 * 自定义异常
 * 1.定义异常类,继承自Exception或RuntimeException类
 * (继承Exception表示编译时异常,也需要捕获)
 * (继承RuntimeException表示运行时异常)
 * 2.重写构造方法,传入异常描述信息,实现其他方法
 * 3.实例化对象,并用throw抛出
 * <p>
 * 异常信息:
 * 1.printStackTrace();异常堆栈信息,包括程序运行到当前类的执行流程,将返回从调用处到异常抛出处的方法调用的栈序列
 * 2.getMessage();返回异常信息描述字符串
 *
 * @author RABBIT2002
 * @date 2020/12/16
 */
public class ExceptionHandling {
    public static void main(String[] args) {
        Object o = null;
        Throwable throwable = null;
        Error error = null;
        Exception exception = null;
        RuntimeException runtimeException = null;
        StackOverflowError stackOverflowError = null;
        ClassNotFoundException classNotFoundException = null;
        NullPointerException nullPointerException = null;

        try {
            ExceptionHandling.classNotFoundException();
        } catch (MyException e) {
            e.printStackTrace();
        }

    }

    static void classNotFoundException() throws MyException {
        try {
            System.out.println("classNotFoundException: begin");
            Class.forName("1.java.lang.String");
            System.out.println("classNotFoundException: end");
            throw new MyException("Exception");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // throw new MyException("Exception");
        } finally {
            System.out.println("classNotFoundException: finally");
        }
    }
}

class MyException extends RuntimeException {
    public MyException(String message) {
        super(message);
    }
}