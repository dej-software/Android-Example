package com.jikexueyuan.chat;

import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created by dej on 2016/11/6.
 */
public class Server {
    public static void main(String[] args) {
        NioSocketAcceptor acceptor = new NioSocketAcceptor();
        acceptor.getFilterChain().addLast("LineCodec", new ProtocolCodecFilter(new TextLineCodecFactory()));
        acceptor.setHandler(new ChatHandler());

        try {
            acceptor.bind(new InetSocketAddress(8000));
            System.out.println("Server started at port 8000");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
