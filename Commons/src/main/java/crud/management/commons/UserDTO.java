package crud.management.commons;

import java.io.Serializable;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String name;

	public UserDTO(String email, String name) {
		this.email = email;
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNume() {
		return name;
	}

	public void setNume(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "UtilizatorDTO [email=" + email + ", name=" + name + "]";
	}
}