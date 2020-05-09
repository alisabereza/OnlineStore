package com.berezovska.store.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;


@Entity
@NoArgsConstructor
@Table (name = "users")
public @Data class User extends BaseEntity {
    @NotEmpty
    @Column (name = "password")
    private String password;
    @NotEmpty
    @Email
    @Column (name = "email")
    private String email;
    @NotEmpty
    @Column (name = "first_name")
    private String firstName;
    @NotEmpty
    @Column (name = "last_name")
    private String lastName;

    @Column (name = "user_role")
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    @Column (name = "status")
    @Enumerated(EnumType.STRING)
    private UserStatus status;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

}
