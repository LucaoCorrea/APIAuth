package com.join4.auth.Services;

import com.join4.auth.Models.UserModel;
import com.join4.auth.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserModel registerUser(UserModel user) {
        String encryptedPassword = encryptPassword(user.getPassword());
        user.setPassword(encryptedPassword);
        return userRepository.save(user);
    }

    public UserModel loginUser(String email, String password) {
    UserModel user = userRepository.findByEmail(email);
    if (user != null && user.getPassword().equals(encryptPassword(password))) {
        return user;
    }

    return null;
}


    private String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error encrypting password", e);
        }
    }
}
