package com.jikexueyuan.chat;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dej on 2016/11/6.
 */
public class ChatHandler extends IoHandlerAdapter {

    private List<IoSession> allSessions = new ArrayList<IoSession>();

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);

        allSessions.add(session);
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        super.sessionClosed(session);

        allSessions.remove(session);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        super.messageReceived(session, message);

        for (IoSession ioSession : allSessions) {
            ioSession.write(message);
        }
    }
}
