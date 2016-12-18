package control;

import java.io.File;

/**
 * Created by dej on 2016/10/24.
 */
public class DeleteFile {
    public static void main(String[] args) {
        File file = new File(FileUtil.FILE_NAME);
        if (file.exists()) {
            file.delete();
            System.out.println("文件已删除");
        }
    }
}
