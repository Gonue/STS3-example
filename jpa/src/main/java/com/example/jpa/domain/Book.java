package com.example.jpa.domain;

import com.example.jpa.domain.listener.Auditable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@EntityListeners(value = AuditingEntityListener.class)
@NoArgsConstructor
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class Book extends BaseEntity implements Auditable {
    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String author;
//    @CreatedDate
//    private LocalDateTime createdAt;
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @PrePersist
//    public void prePersist(){
//        this.createAt = LocalDateTime.now();
//        this.updateAt = LocalDateTime.now();
//    }
//    @PreUpdate
//    public void preUpdate(){
//        this.updateAt = LocalDateTime.now();
//    }
}
