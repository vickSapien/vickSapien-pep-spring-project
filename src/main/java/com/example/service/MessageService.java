package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Message;
import com.example.repository.AccountRepository;
import com.example.repository.MessageRepository;

@Service
@Transactional
public class MessageService {
    MessageRepository messageRepository;
    AccountRepository accountRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository, AccountRepository accountRepository){
        this.messageRepository = messageRepository;
        this.accountRepository = accountRepository;
    }
    
    public Boolean deleteMessage(int message_id){
        if (messageRepository.existsById(message_id)) {
            messageRepository.deleteById(message_id);    
            return true;
        }
        return false;
    }

    public Boolean updateMessageByID(int message_id, Message newMessage){
        Optional<Message> optionalMessage = messageRepository.findById(message_id);
        if (optionalMessage.isPresent() || !optionalMessage.isEmpty())  {
            Message message = optionalMessage.get();
            message.setMessageText(newMessage.getMessageText());
            messageRepository.save(message);
            return true;
        }
        
        return false;
    }

    public Message postMessage(Message message){
        if (message.getMessageText().length() > 254  || !accountRepository.existsById(message.getPostedBy())) {
            message.setMessageText(" ");
        }
        return messageRepository.save(message);

    }

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
