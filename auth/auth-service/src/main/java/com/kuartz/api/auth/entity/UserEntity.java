package com.kuartz.api.auth.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kuartz.api.auth.constraints.UAAConstraints;
import com.kuartz.api.auth.constraints.UserConstraints;
import com.kuartz.core.common.util.KzDateUtil;
import com.kuartz.core.common.util.KzUtil;
import com.kuartz.core.data.jpa.KuartzSequence;
import com.kuartz.core.data.jpa.entity.KuartzEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = UserConstraints.TABLE_NAME, uniqueConstraints = {
        @UniqueConstraint(name = "UIDX_USER_USERNAME", columnNames = {"USERNAME", "DELETED_AT"}),
        @UniqueConstraint(name = "UIDX_USER_EMAIL", columnNames = {"EMAIL", "DELETED_AT"}),
},
       schema = UAAConstraints.SCHEMA_NAME)
@KuartzSequence(name = "USER_SEQ")
public class UserEntity extends KuartzEntity implements UserDetails {

    // todo constraints koyalim.
    @Size(min = UserConstraints.USERNAME_MIN, max = UserConstraints.USERNAME_MAX)
    @NotNull
    @Column(name = "USERNAME")
    private String username;

    // todo constraints koyalim.
    @NotNull
    @Column(name = "PASSWORD")
    private String password;

    @Size(min = UserConstraints.EMAIL_MIN, max = UserConstraints.EMAIL_MAX)
    @NotNull
    @Email
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "EXPIRATION_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Column(name = "LOCKED_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lockedDate;

    @Column(name = "ENABLED")
    private Boolean enabled;

    // fixme cascade not working.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<UserRoleEntity> roleList;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PERSON_ID", foreignKey = @ForeignKey(name = "FK_USER_PERSON"))
    private PersonEntity person;

    public UserEntity() {
        //    do nothing
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
        List<RolePrivilegeEntity> rolePrivilegeRelList = new ArrayList<>();
        if (!KzUtil.isEmpty(roleList)) {
            roleList.stream().map(UserRoleEntity::getRole).map(RoleEntity::getRolePrivilegeRelationList).forEach(
                    rolePrivilegeRelList::addAll);
            rolePrivilegeRelList.forEach(privilege -> authorities.add(privilege.getPrivilege()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        if (!KzUtil.isNull(expirationDate)) {
            return KzDateUtil.goeCompare(expirationDate, KzDateUtil.suankiTarih());
        }
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        if (!KzUtil.isNull(lockedDate)) {
            return KzDateUtil.goeCompare(lockedDate, KzDateUtil.suankiTarih());
        }
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        if (!KzUtil.isNull(enabled)) {
            return this.enabled;
        }
        return true;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<UserRoleEntity> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRoleEntity> roleList) {
        this.roleList = roleList;
    }

    public PersonEntity getPerson() {
        return person;
    }

    public void setPerson(PersonEntity person) {
        this.person = person;
    }
}
