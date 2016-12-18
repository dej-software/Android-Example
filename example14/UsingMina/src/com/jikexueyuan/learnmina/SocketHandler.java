package com.jikexueyuan.learnmina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by dej on 2016/11/6.
 */
public class SocketHandler extends IoHandlerAdapter {

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
        System.out.println("Created");
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);
        System.out.println("Received message:");

//        IoBuffer buffer = (IoBuffer) message;
//        String str = new String(buffer.array(), "UTF-8");
//        System.out.println(str);

        String line = (String) message;
        System.out.println(line);

        if (line.equals("quit")) {
            session.close(true);
        }
    }
}
