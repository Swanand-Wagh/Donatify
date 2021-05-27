package model;

public class User {
	private String username;
	private String password;
	private String userType;
	private String name;
	private String license;
	
	public String getLicense() {
		return license;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User () {}

	public User(String username, String password, String userType, String name,String license) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.name = name;
		this.license = license;
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
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
