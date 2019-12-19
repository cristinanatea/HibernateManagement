package crud.management.commons;

import java.io.Serializable;

public class UtilizatorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;
	private String nume;

	public UtilizatorDTO(String email, String nume) {
		this.email = email;
		this.nume = nume;
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

	public void setNume(String email) {
		this.nume = email;
	}

	@Override
	public String toString() {
		return "UtilizatorDTO [email=" + email + ", nume=" + nume + "]";
	}
}