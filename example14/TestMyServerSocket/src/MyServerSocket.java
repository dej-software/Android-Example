/**
 * 在浏览器中输入 127.0.0.1:20000 测试
 * telnet localhost 20000
 * Created by dej on 2016/11/5.
 */
public class MyServerSocket {
    public static void main(String[] args) {
        new ServerListener().start();
    }
}
