import java.util.Vector;

/**
 * Created by dej on 2016/11/5.
 */
public class ChatManager {

    private ChatManager() {
    }

    private static final ChatManager cm = new ChatManager();

    public static ChatManager getChatManager() {
        return cm;
    }

    Vector<ChatSocket> vector = new Vector<>();

    public void add(ChatSocket socket) {
        vector.add(socket);
    }

    public void publish(ChatSocket socket, String out) {
        for (int i = 0; i < vector.size(); i++) {
            ChatSocket chatSocket = vector.get(i);
            if (!socket.equals(chatSocket)) {
                chatSocket.out(out);
            }
        }
    }
}
