package kolesnick.SummaryTask.db.entity;

public class User extends Entity{
	
	private static final long serialVersionUID = 3706389654730692838L;

	private String login;
	private String password;
	private String adress;
	private String name;
	private String firstname;
	private String lastname;
	private String pasport;
	private int tel;
	private boolean blocked;
	private int roleId;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPasport() {
		return pasport;
	}
	public void setPasport(String pasport) {
		this.pasport = pasport;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	@Override
	public String toString() {
		return "User [id=" + getId() + ", login=" + login + ", password=" + password + ", adress=" + adress + ", name="
				+ name + ", firstname=" + firstname + ", lastname=" + lastname + ", pasport=" + pasport + ", tel=" + tel
				+ ", role_id=" + roleId + " , blocked" + blocked + "]";
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	
	
}
