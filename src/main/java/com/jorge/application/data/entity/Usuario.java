package com.jorge.application.data.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Usuario extends AbstractEntity {

    private String firstName;
    private String lastName;
    private String email;
    @ElementCollection(fetch = FetchType.EAGER)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Telefono> phones;

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
	public Set<Telefono> getPhones() {
		return phones;
	}
	public void setPhones(Set<Telefono> phones) {
		this.phones = phones;
	}
    

	@JsonIgnore
	public List<String> getPhonesStr() {
		List<String> phones = new ArrayList<String>();
		for (Telefono p : this.getPhones()) {
			phones.add(p.getNumber().toString());
		}
		return phones;
	}
}
