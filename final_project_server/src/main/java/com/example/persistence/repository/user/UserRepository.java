package com.example.persistence.repository.user;

import com.example.persistence.entity.user.User;
import com.example.persistence.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository<U extends User> extends BaseRepository<U> {

    Optional<U> findByLogin(String login);

    boolean existsByLogin(String login);
}
