package ch.bbw._project_mvn_openjfx;

public class Customer {
	private String firstname;
	private String lastname;
	private String email;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Customer(String firstname, String lastname, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getEmail() {
		return email;
	}
	

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
		public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return firstname + " " + lastname + "	" + email;
	}


}
