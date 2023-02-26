package com.example.jpa.domain.listener;

import com.example.jpa.domain.UserHistory;
import com.example.jpa.domain.Users;
import com.example.jpa.repository.UserHistoryRepository;
import com.example.jpa.support.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Component
public class UserEntityListener {
    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){
        UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
        Users users = (Users) o;
        UserHistory userHistory = new UserHistory();
        userHistory.setName(users.getName());
        userHistory.setEmail(users.getEmail());
        userHistory.setUsers(users);
        userHistoryRepository.save(userHistory);
    }
}
