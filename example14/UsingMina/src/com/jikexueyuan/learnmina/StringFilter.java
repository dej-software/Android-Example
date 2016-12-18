package com.jikexueyuan.learnmina;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.filterchain.IoFilter;
import org.apache.mina.core.filterchain.IoFilterAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * Created by dej on 2016/11/6.
 */
public class StringFilter extends IoFilterAdapter {

    @Override
    public void messageReceived(NextFilter nextFilter, IoSession session, Object message) throws Exception {
        IoBuffer buffer = (IoBuffer) message;
        String str = new String(buffer.array(), "UTF-8").trim();
        super.messageReceived(nextFilter, session, "StringFilter:" + str);
    }
}
