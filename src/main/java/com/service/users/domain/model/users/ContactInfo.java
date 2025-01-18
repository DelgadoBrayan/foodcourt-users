package com.service.users.domain.model.users;

public class ContactInfo {
    private String documentId;
    private String phone;
    private String email;
    
    public ContactInfo(String documentId, String phone, String email) {
        this.documentId = documentId;
        this.phone = phone;
        this.email = email;
    }
    
    public ContactInfo() {}

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
