package com.sda.phonebook.service;

import com.sda.phonebook.model.PhoneContact;
import com.sda.phonebook.repository.PhoneContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class PhoneContactService {

    @Autowired
    private PhoneContactRepository phoneContactRepository;

    public void createPhoneContact(PhoneContact phoneContact) {
        phoneContactRepository.save(phoneContact);

    }

    public PhoneContact updatePhoneContact(int id) {

        return null;
    }

    @Transactional
    public void deletePhoneContact(int id) {
        phoneContactRepository.deleteById(id);
    }

    public List<PhoneContact> getAllContacts() {
        return phoneContactRepository.findAll();
    }


}
