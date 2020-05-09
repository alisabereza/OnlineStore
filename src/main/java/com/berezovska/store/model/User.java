package com.berezovska.store.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@Table (name = "users")
public @Data class User extends BaseEntity {

    @Column (name = "password")
    private String password;
    @Email
    @Column (name = "email")
    private String email;
    @Column (name = "first_name")
    private String firstName;
    @Column (name = "last_name")
    private String lastName;
    @Column (name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;

}
