package com.sda.phonebook.repository;

import com.sda.phonebook.model.PhoneContact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneContactRepository extends JpaRepository<PhoneContact,Integer> {

}
