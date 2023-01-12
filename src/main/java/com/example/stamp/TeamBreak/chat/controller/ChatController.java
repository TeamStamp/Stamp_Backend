package com.example.stamp.TeamBreak.chat.controller;

import com.example.stamp.TeamBreak.chat.dto.RequestChat;
import com.example.stamp.TeamBreak.chat.service.ChatService;
import com.example.stamp.TeamBreak.common.dto.ResponseMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
public class ChatController {
    @Autowired
    private final SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private final ChatService chatService;

    @MessageMapping("/room/{id}")
        public void sendMessage(@DestinationVariable("id") String id, @Payload RequestChat.MessageDto messageDto) {
        System.out.println(messageDto);
        simpMessagingTemplate.convertAndSend("/sub/room/" + id, messageDto);
    }

    @PostMapping("/api/chat/room")
    public ResponseEntity<ResponseMessage> registerChatRoom(@RequestBody Map<String, String> name){
        chatService.registerRoom(name.get("name"));

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("방 생성 성공")
                .build(), HttpStatus.OK);
    }

    @GetMapping("/api/chat/rooms")
    public ResponseEntity<ResponseMessage> getChatRoom(){

        return new ResponseEntity<>(ResponseMessage.builder()
                .message("방 조회 성공")
                .data(chatService.getAllRoom())
                .build(), HttpStatus.OK);
    }
}

