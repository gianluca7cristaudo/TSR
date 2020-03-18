
public class Editore {
	private String email;
	private String password;
	
	//COSTRUTTORE
	public Editore (String email, String password) {
		this.email=email;
		this.password=password;
	}
	
	// SET E GET
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getEmail() {
		return email;
	}
}
