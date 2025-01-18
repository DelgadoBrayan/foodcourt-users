package com.service.users.domain.model.users;

public class Users {
    private Long id;
    private String fistName;
    private String lastName;
    private Long idRol;
    private String password;
    private ContactInfo contactInfo;
    public Users(Long id, String fistName, String lastName, Long idRol, String password,
            ContactInfo contactInfo) {
        this.id = id;
        this.fistName = fistName;
        this.lastName = lastName;
        this.idRol = idRol;
        this.password = password;
        this.contactInfo = contactInfo;
    }
    
    public Users() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public String getFistName() {return fistName;}
    public void setFistName(String fistName) {this.fistName = fistName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public Long getIdRol() {return idRol;}
    public void setIdRol(Long idRol) {this.idRol = idRol;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public ContactInfo getContactInfo() {return contactInfo;}
    public void setContactInfo(ContactInfo contactInfo) {this.contactInfo = contactInfo;}  
}
