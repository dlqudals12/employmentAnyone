package com.youtubeManagement.data.repository.user;

import com.youtubeManagement.data.model.entity.user.User;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUserId(@NonNull String id);
}
