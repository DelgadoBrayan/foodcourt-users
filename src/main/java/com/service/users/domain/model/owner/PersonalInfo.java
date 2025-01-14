package com.service.users.domain.model.owner;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class PersonalInfo {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    public PersonalInfo() {}

    public PersonalInfo(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(String birthDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.birthDate = LocalDate.parse(birthDate, formatter);
    }

    public boolean isAdult() {
        return Period.between(this.birthDate, LocalDate.now()).getYears() >= 18;
    }

    @Override
    public String toString() {
        return "PersonalInfo [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + "]";
    }

    
}