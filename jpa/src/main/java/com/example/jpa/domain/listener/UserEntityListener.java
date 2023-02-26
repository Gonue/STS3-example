package com.example.jpa.domain.listener;

import com.example.jpa.domain.UserHistory;
import com.example.jpa.domain.Users;
import com.example.jpa.repository.UserHistoryRepository;
import com.example.jpa.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class UserEntityListener {
    @PreUpdate
    @PrePersist
    public void prePersistAndPreUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        Users users = (Users) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setUserId(users.getId());
        userHistory.setName(users.getName());
        userHistory.setEmail(users.getEmail());
        userHistoryRepository.save(userHistory);
    }
}
