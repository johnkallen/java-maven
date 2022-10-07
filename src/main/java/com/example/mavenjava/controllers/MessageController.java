package com.example.mavenjava.controllers;

import com.example.mavenjava.data.Message;
import com.example.mavenjava.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService service;

    @GetMapping("/test")
    public ResponseEntity<List<Message>> test() {
        try {
            List<Message> messages = new ArrayList<>();
            messages.add(new Message("1", "Hello!"));
            messages.add(new Message("2", "Bonjour!"));
            messages.add(new Message("3", "Privet!"));

            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Message>> index() {
        try {
            List<Message> messages = service.findMessages();
            return new ResponseEntity<>(messages, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Message> post(@RequestBody Message message) {
        try {
            service.post(message);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Message> delete(@PathVariable("id") String id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
