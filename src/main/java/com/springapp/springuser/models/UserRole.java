package com.springapp.springuser.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@Entity
@Table(name="user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "userRoles")
    private Set<ApplicationUser> applicationUsers;
}
