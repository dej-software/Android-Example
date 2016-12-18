package com.jikexueyuan.nio.ioeaxmple;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by dej on 2016/11/5.
 */
public class IOExampleMain {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");

//        // Write
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        FileOutputStream fileOutputStream = new FileOutputStream(file);
//        fileOutputStream.write("Hello Java IO".getBytes("UTF-8"));
//        fileOutputStream.close();

        // Read
        if (file.exists()) {
            System.out.println("Read:");
            FileInputStream fileInputStream = new FileInputStream(file);

//            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
//
//            byte[] buffer = new byte[1024];

//            for (int result = 0; result != -1; result = fileInputStream.read(buffer)) {
//                bos.write(buffer, 0, result);
//            }

//            int result = 0;
//            while ((result = fileInputStream.read(buffer)) != -1) {
//                bos.write(buffer, 0, result);
//            }
//
//            byte[] bytesRead = bos.toByteArray();
//
//            bos.close();
//            fileInputStream.close();
//
//            System.out.println(new String(bytesRead, "UTF-8"));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "UTF-8"));
            String line = null;
            StringBuffer content = new StringBuffer();
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line);
            }

            bufferedReader.close();
            fileInputStream.close();
            System.out.println(content);
        }
        System.out.println("End");
    }
}
