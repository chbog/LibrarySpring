package com.bohdan.libraryspring.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "patronymic")
    @Length(min = 5, message = "*Your user patronymic must have at least 5 characters")
    @NotEmpty(message = "*Please provide a patronymic")
    private String patronymic;

    @Column(name = "firstname")
    @Length(min = 5, message = "*Your user firstname must have at least 5 characters")
    @NotEmpty(message = "*Please provide a firstname")
    private String firstName;

    @Column(name = "secondname")
    @Length(min = 5, message = "*Your user secondname must have at least 5 characters")
    @NotEmpty(message = "*Please provide a secondname")
    private String secondName;

    @Column(name = "password")
    @Length(min = 5, message = "*Your password must have at least 5 characters")
    @NotEmpty(message = "*Please provide your password")
    private String password;

    @Column(name = "email")
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @Column(name = "active")
    private Boolean active;

}
