package com.service.users.domain.model.owner;

import com.service.users.infrastucture.exception.InvalidUserException;

public class ContactInfo {
    private Long documentId;
    private Long phone;
    private String email;

    public ContactInfo(Long documentId, Long phone, String email) {
        setDocumentId(documentId);
        setPhone(phone);
        setEmail(email);
    }
 
    public ContactInfo() {}
    
    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        // Validación del documento
        if (documentId == null || documentId <= 0) {
            throw new InvalidUserException("El documento de identidad debe ser numérico y positivo.");
        }
        this.documentId = documentId;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        // Validación del teléfono
        if (phone == null || phone <= 0) {
            throw new InvalidUserException("El número de teléfono debe ser numérico y positivo.");
        }
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // Validación del correo electrónico
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!email.matches(emailRegex)) {
            throw new InvalidUserException("El correo electrónico es inválido.");
        }
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactInfo [documentId=" + documentId + ", phone=" + phone + ", email=" + email + "]";
    }

    
}