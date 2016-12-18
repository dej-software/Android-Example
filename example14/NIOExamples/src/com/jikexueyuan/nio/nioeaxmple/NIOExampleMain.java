package com.jikexueyuan.nio.nioeaxmple;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dej on 2016/11/5.
 */
public class NIOExampleMain {
    public static void main(String[] args) {
        new NIOExampleMain();
        System.out.println("End");
    }

    public NIOExampleMain() {
//        write();
        read();
    }

    void write() {
        File file = new File("data_nio.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                FileChannel channel = fileOutputStream.getChannel();
                channel.write(ByteBuffer.wrap("Hello Java NIO".getBytes("UTF-8")));
                channel.close();
                fileOutputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    void read() {
        File file = new File("data_nio.txt");
        if (file.exists()) {
            FileInputStream fileInputStream = null;

            try {
                fileInputStream = new FileInputStream(file);
                FileChannel channel = fileInputStream.getChannel();

                ByteArrayOutputStream dist = new ByteArrayOutputStream();

                ByteBuffer buffer = ByteBuffer.allocate(1024);

                int result = 0;
                while ((result = channel.read(buffer)) != -1) {
                    buffer.flip();
                    dist.write(buffer.array(), 0, buffer.remaining());
                    buffer.clear();
                }

//                System.out.println(new String(buffer.array(), "UTF-8"));
                System.out.println(new String(dist.toByteArray(), "UTF-8"));
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
