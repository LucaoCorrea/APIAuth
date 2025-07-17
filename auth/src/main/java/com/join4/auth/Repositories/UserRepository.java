package com.join4.auth.Repositories;

import com.join4.auth.Models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
