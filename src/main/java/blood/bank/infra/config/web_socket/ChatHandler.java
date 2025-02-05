package blood.bank.infra.config.web_socket;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class ChatHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> userSessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if(username != null){
            userSessions.put(username, session);
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();

        String[] parts = payload.split(":", 2);
        if(parts.length == 2){
            String destinario = parts[0];
            String conteudo = parts[1];

            WebSocketSession destinatarioSession = userSessions.get(destinario);
            if(destinatarioSession != null && destinatarioSession.isOpen()){
                destinatarioSession.sendMessage(new TextMessage(conteudo));
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String username = (String) session.getAttributes().get("username");
        if(username != null){
            userSessions.remove(username);
        }
    }
}
