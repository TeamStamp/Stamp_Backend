package com.example.stamp.TeamBreak.chat.repository;

import com.example.stamp.TeamBreak.chat.domain.Room;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class ChatRoomRepository {
    private List<Room> list;

    @PostConstruct
    private void init() {
        this.list = new ArrayList<>();
    }

    @PreDestroy
    private void destroy() {

    }

    public void createRoom(String name) {
        this.list.add(new Room(UUID.randomUUID().toString(), name));
    }
    public void registerSessionToRoom(String uuid, String session) {
        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).getUuid().equals(uuid)) {
                list.get(i).registerSession(session);
                break;
            }
        }
    }
    public void unregisterSessionFromRoom(String uuid, String session){
        for(int i = 0 ; i < list.size() ; i++) {
            if(list.get(i).getUuid().equals(uuid)) {
                list.get(i).unregisterSession(session);
                break;
            }
        }
    }
    public List<Room> getAllRoom() {
        return this.list;
    }
}
