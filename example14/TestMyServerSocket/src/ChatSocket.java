import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by dej on 2016/11/5.
 */
public class ChatSocket extends Thread {

    Socket socket;

    public ChatSocket(Socket socket) {
        this.socket = socket;
    }

    public void out(String out) {
        try {
            socket.getOutputStream().write((out + "\r\n").getBytes("UTF-8"));
//            socket.getOutputStream().write(out.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        super.run();

//        BufferedWriter bw = null;
//        try {
//            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
//            int count = 0;
//            while (true) {
//                bw.write("loop:" + count);
//                sleep(1000);
//                count++;
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        int count = 0;
//        while (true) {
//            out("loop:" + count + "\n\r");
//            count++;
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        out("你已经连接到服务器");
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                ChatManager.getChatManager().publish(this, line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
