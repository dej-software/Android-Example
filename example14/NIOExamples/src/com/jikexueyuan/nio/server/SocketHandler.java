package com.jikexueyuan.nio.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * Created by dej on 2016/11/5.
 */
public class SocketHandler {

    ByteBuffer buffer = ByteBuffer.allocate(1024);

    public SocketHandler(AsynchronousSocketChannel channel) {
        channel.read(buffer, channel, new CompletionHandler<Integer, AsynchronousSocketChannel>() {
            @Override
            public void completed(Integer result, AsynchronousSocketChannel attachment) {

                buffer.flip();
                try {
                    String msg = new String(buffer.array(), 0, buffer.remaining(), "UTF-8");
                    System.out.println(msg);

                    if (msg.trim().equals("quit")) {
                        try {
                            attachment.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if (result != -1) {
                    attachment.read(buffer, attachment, this);
                } else {
                    System.out.println("连接已断开");
                }
            }

            @Override
            public void failed(Throwable exc, AsynchronousSocketChannel attachment) {
                System.out.println("读取失败");
//                exc.printStackTrace();
            }
        });
    }
}
