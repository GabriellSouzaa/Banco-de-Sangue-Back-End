package blood.bank.infra.config.web_socket;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.net.URI;
import java.util.Map;

public class JwtHandshakeInterceptor implements HandshakeInterceptor {


    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        URI uri = request.getURI();
        String query = uri.getQuery();

        if(query != null && query.startsWith("token=")){
            String token = query.substring(6);

            String username = JwtUtil.extractUsername(token);
            if(username != null){
                attributes.put("username", username);
                System.out.println("Usuário Autenticado: " + username);
                return true;
            }
        }

        System.out.println("Usuário não autenticado");
        return false;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
