package control;

import java.io.File;

/**
 * Created by dej on 2016/10/24.
 */
public class CreateFolder {
    public static void main(String[] args) {
        File folder = new File(FileUtil.FOLDER_NAME);
        File multiFolder = new File(FileUtil.MULTI_FOLDER_NAME);
        if (!folder.exists()) {
            folder.mkdir();
            System.out.println("文件夹已创建：" + folder.getAbsolutePath());
        }
        if (!multiFolder.exists()) {
            multiFolder.mkdirs();
        }
    }
}
