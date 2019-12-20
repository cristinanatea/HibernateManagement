package crud.management.commons;

public class SignUpDTO {

	private String username;
	private String password;
	private String nume;
	private String phonenumber;
	private String email;

	public SignUpDTO( String nume, String phonenumber, String username, String password,String email) {
		this.username = username;
		this.password = password;
		this.nume = nume;
		this.phonenumber = phonenumber;
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

	public String getNume() {
		return nume;
	}

	public void setNume(String nume) {
		this.nume = nume;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "SignUpDTO [username=" + username + ", password=" + password + ", nume=" + nume + ", phonenumber=" + phonenumber + ", email=" + email + "]";
	}

}
