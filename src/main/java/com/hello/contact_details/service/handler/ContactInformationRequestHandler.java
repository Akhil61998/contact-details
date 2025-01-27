package com.hello.contact_details.service.handler;



import com.hello.contact.ContactDetailsRequest;
import com.hello.contact.ContactDetailsResponse;

import com.hello.contact_details.exceptions.UnknownUserException;
import com.hello.contact_details.repository.ContactDetailsRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactInformationRequestHandler {

    private final ContactDetailsRepository contactDetailsRepository;



    @Autowired
    public ContactInformationRequestHandler(ContactDetailsRepository contactDetailsRepository) {
        this.contactDetailsRepository = contactDetailsRepository;

    }

    public ContactDetailsResponse getUserInformation(final ContactDetailsRequest request) {
        var contact = this.contactDetailsRepository.findById(request.getContactId())
                                      .orElseThrow(()-> new UnknownUserException(request.getContactId()));



        return ContactDetailsResponse.newBuilder()
                .setContactId(contact.getContactId())
                .setAddress(contact.getAddress())
                .setPhoneNumber(contact.getPhoneNumber())
                .build();
    }


}
