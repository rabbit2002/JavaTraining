import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 流
 *
 * 可以按照两种分类方式:
 * 1. 输入流 / 输出流
 * 2. 字节流 / 字符流
 *
 * 字节流 与 字符流 的区别:
 * 字节流 中的数据必须是 byte, 可以用来操作文件
 * 字符流 中的数据可以是 基本数据类型 或 String类型 等字符
 *
 * 输入流 和 输出流 的操作过程:
 * 1. 打开 文件
 * 2. 读取/写入 流
 * 3. 关闭 文件
 *
 * . // 字节流
 * .     // 字节输入流 InputStream                        public abstract class InputStream implements Closeable;
 * .         // 文件字节输入流 FileInputStream            public class FileInputStream extends InputStream
 * .         // FilterInputStream                       public class FilterInputStream extends InputStream
 * .             // 缓冲字节输入流 BufferedInputStream    public class BufferedInputStream extends FilterInputStream
 * .             // 数据字节输入流 DataInputStream        public class DataInputStream extends FilterInputStream implements DataInput
 * .         // 对象字节输入流 ObjectInputStream          public class ObjectInputStream extends InputStream implements ObjectInput, ObjectStreamConstants
 * .
 * .     // 字节输出流 OutputStream                        public abstract class OutputStream implements Closeable, Flushable;
 * .         // 文件字节输出流 FileOutputStream            public class FileOutputStream extends OutputStream
 * .         // FilterOutputStream                       public class FilterOutputStream extends OutputStream
 * .             // 缓冲字节输出流 BufferedOutputStream    public class BufferedOutputStream extends FilterOutputStream
 * .             // 数据字节输出流 DataOutputStream        public class DataOutputStream extends FilterOutputStream implements DataOutput
 * .         // 对象字节输出流 ObjectOutputStream          public class ObjectOutputStream extends OutputStream implements ObjectOutput, ObjectStreamConstants
 * .
 * . // 字符流
 * .     // 字符输入流 Reader                           public abstract class Reader implements Readable, Closeable;
 * .         // 缓冲字符输入流 BufferedReader           public class BufferedReader extends Reader
 * .         // 字符的字节输入流 InputStreamReader      public class InputStreamReader extends Reader
 * .             // 文件字符输入流 FileReader           public class FileReader extends InputStreamReader
 * .
 * .     // 字符输出流 Writer                            public abstract class Writer implements Appendable, Closeable, Flushable;
 * .         // 缓冲字符输出流 BufferedWriter            public class BufferedWriter extends Writer;
 * .         // 字符的字节输出流 OutputStreamWriter      public class OutputStreamWriter extends Writer
 * .             // 文件字符输出流 FileWriter            public class FileWriter extends OutputStreamWriter;
 * .
 * . // 随机访问流 RandomAccessFile              public class RandomAccessFile implements DataOutput, DataInput, Closeable;
 *
 *
 * FileInputStream 与 FileOutputStream:
 * .   文件字节输入/输出流
 * BufferedInputStream 与 BufferedOutputStream:
 * .   缓冲字节输入/输出流
 * DataInputStream 与 DataOutputStream:
 * .   数据字节输入/输出流
 * .   也是字节流, 可以读写基本类型, 但其内部封装依然是读写 byte
 * ObjectInputStream 与 ObjectOutputStream:
 * .   对象字节输入/输出流, 在 序列化 与 反序列化 中使用
 * .   序列化: 将 对象的状态信息 转换为 可以存储或传输的形式 的过程
 * .   反序列化: 将 存储的文件格式 还原为 对象 的过程
 * .   序列化的前提, 被序列化的类必须实现 java.io.Serializable 接口, 该接口是空接口, 仅用于标记是否可序列化
 * .   同时在 序列化 与 反序列化 的设备上 都要存在目标类
 *
 * FileReader 与 FileWriter:
 * .   文件字符输入/输出流
 * BufferedReader 与 BufferedWriter:
 * .   缓冲字符输入/输出流
 * InputStreamReader 与 OutputStreamWriter:
 * .   字符的字节输入/输出流, 可以使用字符流的方式操作字节流
 *
 * RandomAccessFile:
 * .   随机访问流, 继承自 Object, 可以对文件做读写操作
 * .   可以设置文件的模式为 r / w / rw
 * .   r下文件不存在会抛出异常, rw下文件不存在会仅自动创建该文件, 存在时不会覆盖
 * .   内部实现为 byte[] 可以通过 seek() getFilePointer() 等方式操作指针
 * .   还可以对基本类型进行读写操作
 *
 * // TODO Stream Class
 * // TODO BIO NIO Netty
 *
 * @author RABBIT2002
 * @date 2021/1/13
 */
public class IOStream {
    public static void main(String[] args) throws IOException {
        //        func1FileOutputStream();
        //        func1FileInputStream();
        //        func2StreamCopy(".\\test.zip", ".\\test\\123.zip");
        //        func3DataOutputStream();
        //        func3DataInputStream();
        //        func4FileWriter();
        //        func4FileReader();
        //        func5InputStreamWriter();
        //        func5InputStreamReader();
        //        func6RandomAccessFileCopyFile(".\\test.zip", ".\\test\\123.zip");
        //        func7RandomAccessFileWrite();
        //        func7RandomAccessFileReader();
        //        func8ObjectOutputStream();
        //        func8ObjectInputStream();
    }

    // 文件字节输出流 与 缓冲字节输出流
    private static void func1FileOutputStream() throws IOException {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        // 1. 打开文件
        File file = new File(".//test.txt");
        // 2. 输出流
        try {
            // 文件输出流 构造的第二个参数用于指定是否为 追加模式
            fileOutputStream = new FileOutputStream(file, false);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            fileOutputStream.write("_(:з」∠)_\n".getBytes(StandardCharsets.UTF_8));
            fileOutputStream.write(new byte[]{49, 50, 51, 52, 10});

            bufferedOutputStream.write("luuuuuu- -\n".getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.write("qwq".getBytes(StandardCharsets.UTF_8));

            // 冲洗缓冲区, 将缓冲区中的所有数据立刻写入磁盘, 并清空
            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. 关闭文件
        finally {
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    // 文件字节输入流 与 缓冲字节输入流
    private static void func1FileInputStream() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        // 1. 打开文件
        File file = new File(".//test.txt");
        // 2. 读取流
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            // 自定义读取缓冲区
            byte[] bytes = new byte[1024];
            // 每次读取的字节数
            int len = -1;

            // while ((len = fileInputStream.read(bytes, 0, bytes.length)) != -1) {
            //     System.out.println(new String(bytes));
            // }
            while ((len = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                System.out.println(new String(bytes));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 3. 关闭文件
        finally {
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    // 通过 FileInputStream BufferedInputStream FileOutputStream BufferedOutputStream 实现文件拷贝
    private static void func2StreamCopy(String from, String to) throws IOException {
        File fileFrom = new File(from);
        File fileTo = new File(to);

        if (!fileTo.getParentFile().exists()) {
            fileTo.getParentFile().mkdirs();
        }

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(fileFrom);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            fileOutputStream = new FileOutputStream(fileTo);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len = -1;

            while ((len = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

            bufferedOutputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            {
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            }
        }
    }

    // 数据字节输出流 与 缓冲字节输出流
    // DataInputStream 与 DataOutputStream 用于读写基本类型
    private static void func3DataOutputStream() throws IOException {
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        DataOutputStream dataOutputStream = null;

        File file = new File(".//test.txt");
        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            dataOutputStream = new DataOutputStream(bufferedOutputStream);

            dataOutputStream.writeBoolean(true);
            dataOutputStream.writeByte(111);
            dataOutputStream.writeShort(123);
            dataOutputStream.writeInt(456);
            dataOutputStream.writeChars("123123\0");
            dataOutputStream.writeUTF("456456");

            //dataOutputStream.flush();
            // bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    // 数据字节输入流 与 缓冲字节输入流
    // DataInputStream 与 DataOutputStream 用于读写基本类型
    private static void func3DataInputStream() throws IOException {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        DataInputStream dataInputStream = null;

        File file = new File(".//test.txt");
        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            dataInputStream = new DataInputStream(bufferedInputStream);

            System.out.println(dataInputStream.readBoolean());
            System.out.println(dataInputStream.readByte());
            System.out.println(dataInputStream.readShort());
            System.out.println(dataInputStream.readInt());

            char c = '\0';
            while ((c = dataInputStream.readChar()) != '\0') {
                System.out.print(c);
            }
            System.out.println();

            System.out.println(dataInputStream.readUTF());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    // 文件字符输入流 与 缓冲字符输入流
    private static void func4FileWriter() throws IOException {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        File file = new File(".\\test.txt");
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("Hello World!");
            // 使用 newLine() 输出换行
            bufferedWriter.newLine();
            bufferedWriter.write("_(:з」∠)_");
            bufferedWriter.newLine();
            bufferedWriter.write("Welcome!");

            bufferedWriter.flush();
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedWriter.close();
            fileWriter.close();
        }
    }

    // 文件字符输出流 与 缓冲字符输出流
    private static void func4FileReader() throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        File file = new File(".\\test.txt");
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            bufferedReader.close();
            fileReader.close();
        }
    }

    // 字符的字节输入流, 可以使用字符流的方式操作字节流
    private static void func5InputStreamWriter() throws IOException {
        FileOutputStream fileOutputStream = null;
        // BufferedOutputStream bufferedOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;

        File file = new File(".\\test.txt");
        try {
            fileOutputStream = new FileOutputStream(file);
            // bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            // outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);

            // 设置编码 将 String 转换为 byte[]
            outputStreamWriter = new OutputStreamWriter(fileOutputStream, StandardCharsets.UTF_8);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("123456");
            bufferedWriter.newLine();
            bufferedWriter.write("gawuuuuuu");
            bufferedWriter.newLine();
            bufferedWriter.write("_(:з」∠)_");

            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    // 字符的字节输出流, 可以使用字符流的方式操作字节流
    private static void func5InputStreamReader() throws IOException {
        FileInputStream fileInputStream = null;
        // BufferedInputStream bufferedInputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        File file = new File(".\\test.txt");
        try {
            fileInputStream = new FileInputStream(file);
            // bufferedInputStream = new BufferedInputStream(fileInputStream);
            // inputStreamReader = new InputStreamReader(bufferedInputStream);

            // 设置编码 将 String 转换为 byte[]
            inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            bufferedReader = new BufferedReader(inputStreamReader);

            String s = null;
            while ((s = bufferedReader.readLine()) != null) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }

    // 通过 RandomAccessFile 来拷贝文件
    private static void func6RandomAccessFileCopyFile(String from, String to) throws IOException {
        RandomAccessFile randomAccessFileFrom = null;
        RandomAccessFile randomAccessFileTo = null;

        File fileFrom = new File(from);
        File fileTo = new File(to);
        if (!fileTo.getParentFile().exists()) {
            fileTo.getParentFile().mkdirs();
        }

        try {
            randomAccessFileFrom = new RandomAccessFile(fileFrom, "r");
            randomAccessFileTo = new RandomAccessFile(fileTo, "rw");

            byte[] bytes = new byte[1024];
            int len = -1;

            while ((len = randomAccessFileFrom.read(bytes, 0, bytes.length)) != -1) {
                randomAccessFileTo.write(bytes, 0, len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFileTo != null) {
                randomAccessFileTo.close();
            }
            if (randomAccessFileFrom != null) {
                randomAccessFileFrom.close();
            }
        }
    }

    // 通过 RandomAccessFile 随机访问 写入
    private static void func7RandomAccessFileWrite() throws IOException {
        RandomAccessFile randomAccessFile = null;

        File file = new File(".\\test.txt");

        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            // 1 Byte
            randomAccessFile.writeBoolean(false);
            // 4 Byte
            randomAccessFile.writeInt(1024);
            // 15 Byte
            randomAccessFile.writeUTF("_(:з」∠)_");

            randomAccessFile.seek(1);
            randomAccessFile.writeInt(2048);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    // 通过 RandomAccessFile 随机访问 读取
    private static void func7RandomAccessFileReader() throws IOException {
        RandomAccessFile randomAccessFile = null;

        File file = new File(".\\test.txt");

        try {
            randomAccessFile = new RandomAccessFile(file, "rw");

            // 返回当前指针位置
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.readBoolean());
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.readInt());
            System.out.println(randomAccessFile.getFilePointer());
            System.out.println(randomAccessFile.readUTF());
            System.out.println(randomAccessFile.getFilePointer());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        }
    }

    // ObjectOutputStream 对象序列化
    private static void func8ObjectOutputStream() throws IOException {
        File file = new File(".\\Object.obj");

        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        ObjectOutputStream objectOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(file);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

            objectOutputStream.writeObject(new Entity(10, "qwq", 123.456));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (objectOutputStream != null) {
                objectOutputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    // ObjectInputStream 对象反序列化
    private static void func8ObjectInputStream() throws IOException {
        File file = new File(".\\Object.obj");

        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        ObjectInputStream objectInputStream = null;

        try {
            fileInputStream = new FileInputStream(file);
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            objectInputStream = new ObjectInputStream(bufferedInputStream);

            System.out.println((Entity)objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (objectInputStream != null) {
                objectInputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        }
    }
}

class Entity implements Serializable {
    private int a;
    private String s;
    private double d;

    public Entity(int a, String s, double d) {
        this.a = a;
        this.s = s;
        this.d = d;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "a=" + a +
                ", s='" + s + '\'' +
                ", d=" + d +
                '}';
    }
}
