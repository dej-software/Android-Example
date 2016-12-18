package control;

import java.io.File;

/**
 * Created by dej on 2016/10/24.
 */
public class RenameFile {
    public static void main(String[] args) {
        File file = new File(FileUtil.FILE_NAME);
        File newFile = new File("newfile.txt");
        if (file.exists()) {
            file.renameTo(newFile);
            System.out.println("文件已重命名为：" + file.getName());
        }
    }
}
