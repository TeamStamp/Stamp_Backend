package com.example.stamp.TeamBreak.chat.service;

import com.example.stamp.TeamBreak.chat.domain.Room;
import com.example.stamp.TeamBreak.chat.repository.ChatRoomRepository;
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


