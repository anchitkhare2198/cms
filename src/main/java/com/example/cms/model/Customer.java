package com.example.cms.model;
import javax.persistence.*;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cus_Id;
    @Column
    private String cus_firstName;
    @Column
    private String cus_lastName;
    @Column
    private String cus_Email;

    public long getCus_Id() {
        return cus_Id;
    }

    public void setCus_Id(int cus_Id) {
        this.cus_Id = cus_Id;
    }

    public String getCus_firstName() {
        return cus_firstName;
    }

    public void setCus_firstName(String cus_firstName) {
        this.cus_firstName = cus_firstName;
    }

    public String getCus_lastName() {
        return cus_lastName;
    }

    public void setCus_lastName(String cus_lastName) {
        this.cus_lastName = cus_lastName;
    }

    public String getCus_Email() {
        return cus_Email;
    }

    public void setCus_Email(String cus_Email) {
        this.cus_Email = cus_Email;
    }
}
