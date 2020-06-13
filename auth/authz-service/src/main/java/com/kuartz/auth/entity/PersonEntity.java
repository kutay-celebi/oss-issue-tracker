package com.kuartz.auth.entity;

import com.kuartz.core.auth.constraints.PersonConstraints;
import com.kuartz.core.auth.constraints.UAAConstraints;
import com.kuartz.core.auth.enumeration.Gender;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = PersonConstraints.TABLE_NAME, schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = {
               @UniqueConstraint(name = "UIDX_PERSON_IDNAMESURNAME",
                                 columnNames = {"IDENTIFICATION_NUMBER", "NAME", "LAST_NAME", "DELETED_AT"}),
       })
@KuartzSequence(name = "UAA_PERSON_SEQ")
public class PersonEntity extends KuartzEntity {

    @Column(name = "IDENTIFICATION_NUMBER")
    private String identificationNumber;

    @Column(name = "NATIONALITY")
    private String nationality; // TODO: @kutay-celebi 22.03.2020 create nationality country city table.

    @NotNull
    @Column(name = "NAME")
    private String name;

    @Column(name = "MID_NAME")
    private String midName;

    @NotNull
    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "TITLE")
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "BIRTHDAY")
    private Date birthday;

    @Column(name = "GENDER")
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", foreignKey = @ForeignKey(name = "FK_PERSON_CONTACT"))
    private ContactEntity contact;

    // TODO: @kutay-celebi 22.03.2020 keep the past company information of the person
    @ManyToOne
    @JoinColumn(name = "COMPANY_ID", foreignKey = @ForeignKey(name = "FK_USER_PERSON"))
    private CompanyEntity company;

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }
}
