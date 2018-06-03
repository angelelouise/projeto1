import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.ufrn.ws.angprojservice.dominio.Usuario;
import br.ufrn.ws.angprojservice.resource.UsuarioResource;

public class SocketHandler extends TextWebSocketHandler{
	List<WebSocketSession> sessions = new CopyOnWriteArrayList<WebSocketSession>();
	@Autowired
	private UsuarioResource usuarioResource;
	
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message)
	throws InterruptedException, IOException{
		try {
			ObjectMapper objectMapper = new ObjectMapper();
			Usuario u = objectMapper.readValue(message.getPayload(), Usuario.class);
			usuarioResource.inserir(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void sendMessageUsuarioCreated(Usuario u) throws Exception{
		for (WebSocketSession webSocketSession : sessions) {
			ObjectMapper objectMapper = new ObjectMapper();
			String value = objectMapper.writeValueAsString(u);
			if(webSocketSession.isOpen())
				webSocketSession.sendMessage(new TextMessage(value));
			}
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		sessions.add(session);
	}
}
