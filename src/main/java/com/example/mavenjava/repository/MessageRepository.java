package com.example.mavenjava.repository;

import com.example.mavenjava.data.Message;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {

    @Query("select * from messages")
    List<Message> findMessages();
}
