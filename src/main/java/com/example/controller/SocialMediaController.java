package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import com.example.service.AccountService;
import com.example.service.MessageService;

/**
 * TODO: You will need to write your own endpoints and handlers for your controller using Spring. The endpoints you will need can be
 * found in readme.md as well as the test cases. You be required to use the @GET/POST/PUT/DELETE/etc Mapping annotations
 * where applicable as well as the @ResponseBody and @PathVariable annotations. You should
 * refer to prior mini-project labs and lecture materials for guidance on how a controller may be built.
 */
@RestController
public class SocialMediaController {
    MessageService messageService;
    
    @Autowired
    public SocialMediaController(MessageService messageService){
        this.messageService = messageService;
    }

    //@PostMapping("/register")
    
    @GetMapping("/messages/{message_id}")
    public @ResponseBody ResponseEntity<Message> getMessageIDPathVariable(@PathVariable int message_id){
        Message message = messageService.getMessageByID(message_id);
        return ResponseEntity.status(200).body(message);
    }

    @GetMapping("/messages")
    public @ResponseBody ResponseEntity<List<Message>> findAllmessages(){
        List<Message> messagesList = messageService.findAllmessages();
        return ResponseEntity.status(200).body(messagesList);
    }
    //@GetMapping("/accounts/{account_id}/messages")
   

    // @PostMapping(value ="/messages")
    // public ResponseEntity<Message> postMessage(@RequestBody Message messages){
    //     return ResponseEntity.status(200).body(messages);
    //}

    // @PostMapping("/login")
    // public ResponseEntity<Message> postLogin(@RequestBody Message login){
    //     return ResponseEntity.status(200).body(login);
    // }
   
    // @DeleteMapping("/messages/{message_id}")
    // public ResponseEntity<Message> deleteMessage(@PathVariable Message message) {
        
    //     return ResponseEntity.status(200).body(message);
    // }
   
    // @PatchMapping("/messages/{message_id}")
    // public ResponseEntity<Message> updateMessage(@PathVariable int message_id, @RequestBody Message message) {
        
    //     return ResponseEntity.status(200).body(message);
    // }
}

