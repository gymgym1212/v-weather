package com.example.bigdata.controller;

import com.example.bigdata.model.InMessage;
import com.example.bigdata.model.OutMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameInfoController {

    @MessageMapping("/v1/chat")
    @SendTo("/topic/game_chat")
    public OutMessage gameInfo(InMessage message) {
        return new OutMessage(message.getContent(), message.getBody(), message.getView());
    }


    @MessageMapping("/v1/control")
    @SendTo("/topic/view_control")
    public OutMessage controlInfo(InMessage message) {
        return new OutMessage(message.getContent(), message.getBody(), message.getView());
    }

}
