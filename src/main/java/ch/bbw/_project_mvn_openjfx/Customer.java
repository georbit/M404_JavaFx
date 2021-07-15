package ch.bbw._project_mvn_openjfx;

public class Customer {
	private String firstname;
	private String lastname;
	private String email;
	private Music music;
	
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String firstname, String lastname, String email) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
	}

	public Customer(String firstname, String lastname, String email, Music music) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.music = music;
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

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return  firstname + ' '+ lastname;
	}

	public String ToStringDebug() {
		return "Customer{" +
				"firstname='" + firstname + '\'' +
				", lastname='" + lastname + '\'' +
				", email='" + email + '\'' +
				", music=" + music +
				'}';
	}
}
