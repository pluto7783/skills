package com.websocket.karolus.chat.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

@Controller
@ServerEndpoint("/websocket")
@Slf4j
public class MessageController extends Socket {
    private static final List<Session> session = new ArrayList<>();

    @OnOpen
    public void open(Session newUser) {
        log.debug("===== websocket connected ======");

        session.add(newUser);

        log.debug("user id : {}", newUser.getId());
    }

    @OnMessage
    public void getMessage(Session recieveSession, String message) throws IOException {
        log.debug("==== on message ==== : {}", message);
        for (int i = 0; i < session.size(); i++) {
            if(!recieveSession.getId().equals(session.get(i).getId())) {
                session.get(i).getBasicRemote().sendText("상대 :" + message);
            } else {
                session.get(i).getBasicRemote().sendText("나 :" + message);

            }

        }

    }

}
