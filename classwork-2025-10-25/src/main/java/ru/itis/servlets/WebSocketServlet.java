package ru.itis.servlets;

import lombok.SneakyThrows;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@ServerEndpoint("/ws")
public class WebSocketServlet {

    private static final Set<Session> sessions = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("New user: ID = " + session.getId());
        sessions.add(session);
    }

    @OnMessage
    @SneakyThrows
    public void onMessage(String message, Session sender) {
        System.out.println("New message: " + message + ", sender ID = " + sender.getId());
        message = "{" + Instant.now() + "} " + message;
        for(Session target : sessions) {
            target.getBasicRemote().sendText(message);
        }
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("Disconnected: " + session.getId());
        sessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.err.println("Error: ID = " + session.getId() +
                ", err = " + throwable.getMessage());
        sessions.remove(session);
    }

}
