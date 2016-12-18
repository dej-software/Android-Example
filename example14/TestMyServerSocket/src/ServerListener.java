import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

/**
 * Created by dej on 2016/11/5.
 */
public class ServerListener extends Thread {

    @Override
    public void run() {
        super.run();
        try {
            // Port
            ServerSocket serverSocket = new ServerSocket(20000);
            while (true) {
                // 等待连接
                Socket socket = serverSocket.accept();
                // 建立连接
                JOptionPane.showMessageDialog(null, "有客户端连接到了20000端口");
                // 将Socket传递给新的线程
                ChatSocket chatSocket = new ChatSocket(socket);
                chatSocket.start();
                ChatManager.getChatManager().add(chatSocket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
