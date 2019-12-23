package crud.management.persistence.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "utilizator")
public class Utilizator implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue 
    private int utilizatorID;
	private String username;
	private String password;
	private String email;
	private String nume;
	private String phoneNumber;

	public Utilizator() {
		super();
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Utilizator [  username=" + username + ", password=" + password
				+ ", email=" + email + ", nume=" + nume + ", phonenumber=" + phoneNumber + "]";
	}



	
}