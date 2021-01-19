/**
 * Java 中 使用 File类 来表示 目录 及 文件
 *
 * 实例方法:
 * // 根据 抽象路径名 创建目录,
 * // 创建成功为 true, 否则为 false
 * public boolean mkdir();
 * // 根据 抽象路径名 创建目录, 包括可能不存在的父目录, 在创建失败时可能已经创建了一些父目录
 * // 仅当 同时创建了 所有的父目录和该目录 为 ture, 否则为 false
 * public boolean mkdirs();
 *
 * // 该文件或目录是否存在
 * public boolean exists();
 *
 * // 该路径的文件是否是一个目录
 * public boolean isDirectory();
 * // 该路径的文件是否是一个普通文件
 * public boolean isFile();
 *
 * // 该文件是否为隐藏文件
 * public boolean isHidden();
 * // 测试是否可读这个文件
 * public boolean canRead();
 * // 测试是否可写这个文件
 * public boolean canWrite();
 * // 测试是否可执行这个文件
 * public boolean canExecute();
 *
 * // 此路径名是否为绝对路径
 * public boolean isAbsolute();
 * // 返回该文件的大小, 如果该文件是目录, 则大小为0
 * public long length();
 *
 * // 返回 指定路径目录下 所有的文件
 * // 如果该路径是文件 返回 null, 否则返回一个不包含 当前目录.和 父目录.. 的 File数组
 * public File[] listFiles()
 *
 * // 重命名文件, 重命名到 不同路径下 即完成 移动+重命名
 * public boolean renameTo(File dest)
 *
 * 类方法:
 * // 所有的可用系统根
 * public static File[] listRoots();
 *
 * 类属性:
 * // The system-dependent default name-separator character
 * // 系统依赖的默认名称分割符
 * File.separator
 * // The system-dependent path-separator character
 * // 系统依赖的路径分隔符
 * File.pathSeparator
 *
 * IO包中提供了部分 函数式接口 用于处理文件过滤
 * // TODO 函数式接口
 *
 * @author RABBIT2002
 * @date 2021/1/12
 */
import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

public class FileClass {
    public static void main(String[] args) {
        func1();
        System.out.println();

        func2(".");
        System.out.println();

        func3();
        System.out.println();

        func4(".\\1.txt", ".\\test\\2.txt");
    }

    private static void func1() {
        // 系统依赖的默认名称分割符
        System.out.println("File.separator: " + File.separator);
        // 系统依赖的路径分隔符
        System.out.println("File.pathSeparator: " + File.pathSeparator);
        // 所有的可用系统根
        System.out.println("File.listRoots(): \n" + Arrays.toString(File.listRoots()));

        System.out.println();

        File file1 = new File("TestDir" + File.separatorChar + "TestDir");
        System.out.println("file1.getAbsoluteFile(): " + file1.getAbsoluteFile());
        System.out.println("file1.mkdir(): " + file1.mkdir());
        System.out.println("file1.mkdirs(): " + file1.mkdirs());
        System.out.println("file1.listFiles(): " + file1.listFiles());
        System.out.println("file1.isAbsolute(): " + file1.isAbsolute());

        System.out.println();

        File file2 = new File("C:\\WINDOWS\\system32\\cmd.exe");
        System.out.println("file2.getAbsoluteFile(): " + file2.getAbsoluteFile());
        System.out.println("file2.length(): " + file2.length());
        System.out.println("file2.exists(): " + file2.exists());
        System.out.println("file2.isDirectory(): " + file2.isDirectory());
        System.out.println("file2.isFile(): " + file2.isFile());
        System.out.println("file2.isHidden(): " + file2.isHidden());
        System.out.println("file2.isAbsolute(): " + file2.isAbsolute());
        System.out.println("file2.canRead()" + file2.canRead());
        System.out.println("file2.canWrite(): " + file2.canWrite());
        System.out.println("file2.canExecute(): " + file2.canExecute());
    }

    // 递归搜索 pathName目录 下的所有 .java文件
    private static void func2(String pathName) {
        if (pathName == null || "".equals(pathName)) {
            System.out.println("NO PATHNAME");
            return;
        }
        File file = new File(pathName);
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                func2(f.getAbsolutePath());
            } else {
                if (f.getName().toLowerCase().endsWith(".java")) {
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }

    // 一个文件过滤器, 过滤 .exe文件
    private static void func3() {
        FileFilter fileFilter = (pathName) -> {
            return pathName.getName().toLowerCase().endsWith(".exe");
        };

        File file = new File("C:\\Windows\\");
        File[] files = file.listFiles(fileFilter);
        for (File f : files) {
            System.out.println(f.getAbsolutePath());
        }
    }

    // 重命名文件
    private static void func4(String from, String to) {
        File fileFrom = new File(from);
        File fileTo = new File(to);
        if (!fileTo.getParentFile().exists()) {
            if (!fileTo.getParentFile().mkdirs()) {
                System.out.println("target directory created failed");
                return;
            }
        }
        if (fileFrom.isFile()) {
            System.out.println(fileFrom.renameTo(fileTo));
        }
    }
}
