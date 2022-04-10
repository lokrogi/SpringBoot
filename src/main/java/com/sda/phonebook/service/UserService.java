package com.sda.phonebook.service;

import com.sda.phonebook.controller.HomePageController;
import com.sda.phonebook.controller.PhoneContactController;
import com.sda.phonebook.model.User;
import com.sda.phonebook.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneContactController phoneContactController;

    @Autowired
    private HomePageController homePageController;

    public boolean createUser(User user) {
        boolean isRegistered = isUserRegistered(user);

        if(isRegistered) {
            return false;
        } else {
            userRepository.save(user);
            phoneContactController.setUser(user);
            homePageController.setUser(user);
            return true;
        }
    }

    private boolean isUserRegistered(User user) {
        return userRepository.existsByUserName(user.getUserName());

    }

    public void logout() {
        phoneContactController.setUser(null);
        homePageController.setUser(null);
    }

    public boolean login(User user) {
        User foundUser = userRepository.findByUserName(user.getUserName());

        if(foundUser != null) {
            String correctPass = foundUser.getPassword();
            if(correctPass.equals(user.getPassword())){
                phoneContactController.setUser(user);
                homePageController.setUser(user);
                return true;
            }
        }
        return false;

    }


}
