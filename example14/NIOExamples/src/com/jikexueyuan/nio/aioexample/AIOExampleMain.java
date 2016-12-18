package com.jikexueyuan.nio.aioexample;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.StandardOpenOption;

/**
 * Created by dej on 2016/11/5.
 */
public class AIOExampleMain {
    public static void main(String[] args) throws IOException {
        new AIOExampleMain();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public AIOExampleMain() throws IOException {
//        write();
        read();
    }

    void write() throws IOException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("data_aio.txt").toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
//        Future<Integer> future = channel.write(ByteBuffer.wrap("Hello Java AIO".getBytes("UTF-8")), 0);
        channel.write(ByteBuffer.wrap("Hello Java AIO".getBytes("UTF-8")), 0, null, new CompletionHandler<Integer, Object>() {
            @Override
            public void completed(Integer result, Object attachment) {
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("End");
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
                try {
                    channel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ByteBuffer buffer = ByteBuffer.allocate(2);

    void read() throws IOException {
        AsynchronousFileChannel channel = AsynchronousFileChannel.open(new File("data_aio.txt").toPath(), StandardOpenOption.READ);

        final int[] position = {0};
        channel.read(buffer, position[0], channel, new CompletionHandler<Integer, AsynchronousFileChannel>() {
            @Override
            public void completed(Integer result, AsynchronousFileChannel attachment) {

                if (result != -1) {
                    buffer.flip();
                    System.out.println(new String(buffer.array()).trim());
                }

                if (result != -1) {
                    position[0] += result;
                    channel.read(buffer, position[0], channel, this);
                } else {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("End");
                }
            }

            @Override
            public void failed(Throwable exc, AsynchronousFileChannel attachment) {
                exc.printStackTrace();
            }
        });
    }
}
