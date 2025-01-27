package com.hello.contact_details.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ContactDetails {
    @Id
    private Integer contactId;

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private String Address;
    private String phoneNumber;
}