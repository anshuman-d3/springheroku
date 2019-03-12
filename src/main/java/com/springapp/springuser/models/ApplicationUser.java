package com.springapp.springuser.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="user", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class ApplicationUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private String email;
    @Column(unique = true, length = 20)
    private String username;
    private String password;

    @Transient
    @JsonIgnore
    private String confirmPassword;

    @ManyToMany
    @JsonIgnore
    private Set<UserRole> userRoles;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
