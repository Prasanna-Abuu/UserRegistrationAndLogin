package com.kavanant.service;
import com.kavanant.model.User;
import com.kavanant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UserService {
    
    
    @Autowired
    private UserRepository userRepository;
    
    private final BCryptPasswordEncoder passwordEncoder;
    
    public UserService() {
        this.passwordEncoder = new BCryptPasswordEncoder(); // Initialize BCryptPasswordEncoder
    }
    
    
    
    // Updated register user method to hash the password
    public String registerUser(User user) {
        // Check if email already exists
        Optional<User> existingUserByEmail = userRepository.findByEmail(user.getEmail());
        if (existingUserByEmail.isPresent()) {
            return "Error: This email is already registered.";
        }
        // Check if phone number already exists
        Optional<User> existingUserByPhone = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if (existingUserByPhone.isPresent()) {
            return "Error: This phone number is already registered.";
        }
        // Hash the password before saving
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword); // Set the hashed password
        userRepository.save(user); // Save the new user
        return "User registered successfully!";
    }
    
    
    

    public String loginUser(String identifier, String password) {
    	
        // Try to find by email
        Optional<User> userByEmail = userRepository.findByEmail(identifier);
        if (userByEmail.isPresent()) {
            if (passwordEncoder.matches(password, userByEmail.get().getPassword())) {
                return "Login successful!";
            } else {
                return "Error: Incorrect password.";
            }
        }
        
        // Try to find by phone number if email didn't match
        Optional<User> userByPhone = userRepository.findByPhoneNumber(identifier);
        if (userByPhone.isPresent()) {
            if (passwordEncoder.matches(password, userByPhone.get().getPassword())) {
                return "Login successful!";
            } else {
                return "Error: Incorrect password.";
            }
        }
     
        return "Error: User not found.";
    }
    
    
    
    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}