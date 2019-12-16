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

	public Utilizator() {
		super();
	}

	public int getUtilizatorID() {
		return utilizatorID;
	}

	public void setUtilizatorID(int utilizatorID) {
		this.utilizatorID = utilizatorID;
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

	@Override
	public String toString() {
		return "Utilizator [utilizatorID=" + utilizatorID + ", username=" + username + ", password=" + password
				+ ", email=" + email + "]";
	}

}