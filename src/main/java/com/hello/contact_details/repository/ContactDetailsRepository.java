package com.hello.contact_details.repository;

import com.hello.contact_details.entity.ContactDetails;
import org.springframework.data.repository.CrudRepository;

public interface ContactDetailsRepository extends CrudRepository<ContactDetails,Integer>{
}
