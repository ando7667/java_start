package JavaCoreSeminar_2.tictactoe;

import java.io.*;

public class BackupFileDir {
    public static void main(String[] args) throws IOException {
        String srcDir = "./src/JavaCoreSeminar_2/tictactoe";
        String dstDir = "./backup";
        backupDir(new File(srcDir), new File(dstDir));
    }


    public static void backupDir (File srcDir, File dstDir) throws IOException {
        // если исходный путь является директорией
        if (srcDir.isDirectory()) {
            // если не существует папка назначения, то создадим её
            if (!dstDir.exists()) {
                if(!dstDir.mkdir()){
                    throw new SecurityException("Не могу создать директорий назначения!");
                }
            }

            String[] files = srcDir.list();
            // если в исходной директории есть файлы
            if (files != null) {
                for (String file : files) {
                    copyFile(new File(srcDir, file), new File(dstDir, file));
                }
            }
        }else {
            throw new IllegalArgumentException("Исходный путь не является директорией!");
        }
    }

    public static void copyFile(File srcFile, File dstFile) throws IOException {
        if (srcFile.isFile()) {
            InputStream in = new FileInputStream(srcFile);
            OutputStream out = new FileOutputStream(dstFile);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = in.read(buffer)) > 0) {
                out.write(buffer, 0 , len);
            }
            in.close();
            out.close();
        }
    }
}
