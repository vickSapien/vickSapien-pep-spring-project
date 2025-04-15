package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Message;
import com.example.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    
    // public Message deleteMessage(Message message){
    //     return messageRepository.delete(message);
    // }

    // public Message updateMessageByID(Message message){
    //     return messageRepository.updateMessageByID(message);
    // }

    // public Message postMessage(Message message){
    //     return messageRepository.postMessage(message);
    //}

    public List<Message> findAllmessages(){
        return messageRepository.findAll();
    }

    // public List<Message> getAllMessageByUser(int account_id){
    //     return messageRepository.getAllMessageByUser(account_id);
    // }

    public Message getMessageByID(int message_id){
        Optional<Message> optionalMessage = messageRepository.findById(message_id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            return message;
        }
        return null;
    }


}
