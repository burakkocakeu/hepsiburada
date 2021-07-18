package com.example.hb.entity;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class UserEntity {

    private static Log log = LogFactory.getLog(UserEntity.class);

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @PrePersist
    public void logNewUserAttempt() {
        log.info("Attempting to add new user '" + name + "' with id: " + id);
    }

    @PostPersist
    public void logNewUserAdded() {
        log.info("Added user '" + name + "' with id: " + id);
    }

    @PreRemove
    public void logUserRemovalAttempt() {
        log.info("Attempting to delete user: " + name);
    }

    @PostRemove
    public void logUserRemoval() {
        log.info("Deleted user: " + name);
    }

    @PreUpdate
    public void logUserUpdateAttempt() {
        log.info("Attempting to update user: " + name);
    }

    @PostUpdate
    public void logUserUpdate() {
        log.info("Updated user: " + name);
    }

    @PostLoad
    public void logUserLoad() {
        log.info("Load user: " + id + ". " + name);
    }

}
