package com.jorge.application.data.entity;

import javax.persistence.Entity;

@Entity
public class Telefono extends AbstractEntity {

    private Integer number;

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

    

}
