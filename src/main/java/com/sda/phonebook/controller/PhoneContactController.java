package com.sda.phonebook.controller;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.model.User;
import com.sda.phonebook.service.PhoneContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@Controller
public class PhoneContactController {

    @Autowired
    private PhoneContactService phoneContactService;

    private User user;

    private Logger logger = Logger.getLogger(PhoneContactController.class.getName());

    public void setUser(User user) {
        this.user = user;
    }

    @RequestMapping(value = "/createcontact", method = RequestMethod.POST)
    public String addContact(PhoneContact phoneContact) {
        logger.info("Saving contact: " + phoneContact);
        phoneContactService.createPhoneContact(phoneContact);
        logger.info("Contact " + phoneContact + " successfully saved!");

        return "success";
    }

    @RequestMapping("/contacts")
    public String displayAllContacts(Model model) {
        if(user != null) {
            model.addAttribute("contacts", phoneContactService.getAllContacts());
            return "contacts";
        } else {
            return "redirect: ";
        }
    }

}
