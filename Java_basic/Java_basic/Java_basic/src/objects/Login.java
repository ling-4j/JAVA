package objects;

public class Login {
	private String username;
	private String pass;
	/**
	 * @param username
	 * @param pass
	 */
	public Login() {
		this.username = "nhom1";
		this.pass = "123456";
	}
	public Login(String username, String pass) {
		super();
		this.username = username;
		this.pass = pass;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	

}
