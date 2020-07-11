package com.kuartz.api.auth.entity;

import com.kuartz.api.auth.constraints.CompanyConstraints;
import com.kuartz.api.auth.constraints.UAAConstraints;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = CompanyConstraints.TABLE_NAME, schema = UAAConstraints.SCHEMA_NAME,
       uniqueConstraints = {
               @UniqueConstraint(name = "UIDX_COMPANY_NAME", columnNames = {"NAME", "DELETED_AT"}),
       })
@KuartzSequence(name = "UAA_COMPANY_SEQ")
public class CompanyEntity extends KuartzEntity {

    @Column(name = "NAME")
    private String name;

    // TODO: @kutay-celebi 22.03.2020 link country region table
    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "SHORT_NAME")
    private String shortName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", foreignKey = @ForeignKey(name = "FK_COMPANY_CONTACT"))
    private ContactEntity contact;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public ContactEntity getContact() {
        return contact;
    }

    public void setContact(ContactEntity contact) {
        this.contact = contact;
    }
}
