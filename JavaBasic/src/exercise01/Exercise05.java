package exercise01;

import java.io.*;

/**
 * 复制文件
 *
 * @author RABBIT2002
 * @date 2021/1/16
 */
public class Exercise05 {
    public static void main(String[] args) throws IOException {
        copy("d:\\java", "d:\\copy\\");
    }

    private static void copy(String fromPath, String toPath) throws IOException {
        File from = new File(fromPath);
        File to = new File(toPath);

        if (!to.exists()) {
            to.mkdirs();
        }

        File[] files = from.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                copy(file.getAbsolutePath(), to.getAbsolutePath() + "\\" + file.getAbsolutePath().substring(file.getAbsolutePath().lastIndexOf("\\") + 1));
            } else if (file.getAbsoluteFile().getName().toLowerCase().endsWith(".java")) {
                copyFile(file, new File(to.getAbsolutePath() + "\\" + file.getName()));
            }
        }
    }

    private static void copyFile(File fromFile, File toFile) throws IOException {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        byte[] bytes = new byte[1024];
        int len = -1;

        try {
            fileInputStream = new FileInputStream(fromFile);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            fileOutputStream = new FileOutputStream(toFile);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            while ((len = bufferedInputStream.read(bytes, 0, bytes.length)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }

            bufferedOutputStream.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }

        }


    }

}
