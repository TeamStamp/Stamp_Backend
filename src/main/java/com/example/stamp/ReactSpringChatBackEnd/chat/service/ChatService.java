package com.example.stamp.ReactSpringChatBackEnd.chat.service;

import com.example.stamp.ReactSpringChatBackEnd.chat.domain.Room;
import com.example.stamp.ReactSpringChatBackEnd.chat.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRoomRepository chatRoomRepository;

    //
    public void registerRoom(String name){
        chatRoomRepository.createRoom(name);
    }

    public List<Room> getAllRoom(){
        return chatRoomRepository.getAllRoom();
    }
}


