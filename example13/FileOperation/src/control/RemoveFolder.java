package control;

import java.io.File;

/**
 * Created by dej on 2016/10/24.
 */
public class RemoveFolder {
    public static void main(String[] args) {
        File folder = new File(FileUtil.FOLDER_NAME);
        File multiFolder = new File(FileUtil.MULTI_FOLDER_NAME);
        if (folder.exists()) {
            System.out.println(folder.delete());
        }
        if (multiFolder.exists()) {
            multiFolder.delete();
        }
    }
}
