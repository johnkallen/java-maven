package com.example.mavenjava.service;

import com.example.mavenjava.data.Message;
import com.example.mavenjava.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageRepository db;

    public List<Message> findMessages() {
        return db.findMessages();
    }

    public void post(Message message) {
        db.save(message);
    }

    public void delete(String id) {
        db.deleteById(id);
    }

}
