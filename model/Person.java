package model;

import java.io.Serializable;

public abstract class Person implements Serializable {
	protected String name;
	protected String email;

	public Person(String n, String e) {
		name = n;
		email = e;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String n) {
		this.name = n;
	}

	public void setEmail(String e) {
		this.email = e;
	}

	public String toString() {
		return "Name: " + name + "\nEmail: " + email;
	}

	// Name: Yael Salazar
	// Email: random@gmail.com
}
