package jp.canetrash.sample.servlet31;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author tfunato
 * 
 */
@ServerEndpoint("/echo")
public class EchoEndPointWebsocket {

	static Set<Session> sessions = Collections
			.synchronizedSet(new HashSet<Session>());

	@OnMessage
	public void onMessage(String msg) {
		System.out.println("##### onMessage:" + msg);
		for (Session s : sessions) {
			s.getAsyncRemote().sendText(msg);
		}
	}

	@OnOpen
	public void onOpen(Session session) {
		System.out.println("##### onOpen:" + session.getId());
		sessions.add(session);
	}

	@OnClose
	public void onClose(Session session) {
		System.out.println("##### onClose:" + session.getId());
		sessions.remove(session);
	}
}
