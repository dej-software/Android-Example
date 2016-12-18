package control;

import java.io.File;
import java.io.IOException;

/**
 * Created by dej on 2016/10/24.
 */
public class CreateFile {
    public static void main(String[] args) {
        File file = new File(FileUtil.FILE_NAME);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("文件已经创建，路径：" + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("文件已经存在");
            System.out.println("文件名：" + file.getName());
            System.out.println("文件绝对路径：" + file.getAbsolutePath());
            System.out.println("文件相对路径：" + file.getPath());
            System.out.println("文件大小：" + file.length() + "字节");
        }
    }
}
