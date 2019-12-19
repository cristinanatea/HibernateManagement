package crud.management.commons;

import java.io.Serializable;

public class UtilizatorDTOE implements Serializable {
	private static final long serialVersionUID = 1L;

	private String email;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UtilizatorDTO [email=" + email +  "]";
	}

	
}