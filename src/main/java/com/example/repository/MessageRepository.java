package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.entity.Message;

@EnableJpaRepositories
public interface MessageRepository extends JpaRepository<Message, Integer> {


}
