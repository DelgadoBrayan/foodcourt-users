package com.service.users.domain.model.owner;

public class Owner {
    private Long id;
    private PersonalInfo personalInfo;
    private ContactInfo contactInfo;
    private AccountInfo accountInfo;
    
    public Owner(Long id, PersonalInfo personalInfo, ContactInfo contactInfo, AccountInfo accountInfo) {
        this.id = id;
        this.personalInfo = personalInfo;
        this.contactInfo = contactInfo;
        this.accountInfo = accountInfo;
    }
    
    public Owner() {}

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}

    public PersonalInfo getPersonalInfo() {return personalInfo;}
    public void setPersonalInfo(PersonalInfo personalInfo) {this.personalInfo = personalInfo;}

    public ContactInfo getContactInfo() {return contactInfo;}
    public void setContactInfo(ContactInfo contactInfo) {this.contactInfo = contactInfo;}

    public AccountInfo getAccountInfo() {return accountInfo;}
    public void setAccountInfo(AccountInfo accountInfo) {this.accountInfo = accountInfo;}

    public boolean isAdult() {return personalInfo.isAdult();}

}
