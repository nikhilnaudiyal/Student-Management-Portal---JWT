package com.bct.app.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "admin_table")
public class User implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;

	@NotNull
	@NotEmpty
	// @Column(name = "user_name", nullable = false, length = 100)
	private String username;

	private String role_assigned;

	@Column(unique = true)
	@Email(message = "Please enter valid email id")
	private String email;

	private String contact;

	private String dob;

	private String gender;

	@NotEmpty(message = "Password can't be empty")
	@Size(min = 6, message = "Password should be minimum of 6 characters")
	private String password;

	private boolean isActive;

//	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//	private StudentInfo studentInfo;

	@JsonIgnore
	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user", referencedColumnName = "user_id"), inverseJoinColumns = @JoinColumn(name = "role", referencedColumnName = "id"))
	private Set<Role> role = new HashSet<>();

	public Collection<? extends GrantedAuthority> getAuthorities() {

		List<SimpleGrantedAuthority> authories = this.role.stream()
				.map((role) -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());

		return authories;
	}

	public User(int user_id, @NotNull @NotEmpty String username, String firstname, String lastname,
			String role_assigned, @Email(message = "Please enter valid email id") String email, String contact,
			String dob, String gender,
			@NotEmpty(message = "Password can't be empty") @Size(min = 6, message = "Password should be minimum of 6 characters") String password,
			boolean isActive, StudentInfo studentInfo, Set<Role> role) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.role_assigned = role_assigned;
		this.email = email;
		this.contact = contact;
		this.dob = dob;
		this.gender = gender;
		this.password = password;
		this.isActive = isActive;

		this.role = role;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", role_assigned=" + role_assigned + ", email="
				+ email + ", contact=" + contact + ", dob=" + dob + ", gender=" + gender + ", password=" + password
				+ ", isActive=" + isActive + ", role=" + role + ", getAuthorities()=" + getAuthorities()
				+ ", getUser_id()=" + getUser_id() + ", getEmail()=" + getEmail() + ", getRole()=" + getRole()
				+ ", getRole_assigned()=" + getRole_assigned() + ", getContact()=" + getContact() + ", getDob()="
				+ getDob() + ", getGender()=" + getGender() + ", isActive()=" + isActive() + ", getPassword()="
				+ getPassword() + ", getUsername()=" + getUsername() + ", isAccountNonExpired()="
				+ isAccountNonExpired() + ", isAccountNonLocked()=" + isAccountNonLocked()
				+ ", isCredentialsNonExpired()=" + isCredentialsNonExpired() + ", isEnabled()=" + isEnabled()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public User() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRole() {
		return role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public String getRole_assigned() {
		return role_assigned;
	}

	public void setRole_assigned(String role_assigned) {
		this.role_assigned = role_assigned;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch =FetchType.LAZY)
//	private List<Subject> Subject = new ArrayList<>();

	@Override
	public String getPassword() {

		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
