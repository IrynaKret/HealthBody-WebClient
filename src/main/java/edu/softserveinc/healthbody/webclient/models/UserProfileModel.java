package edu.softserveinc.healthbody.webclient.models;

public class UserProfileModel {

	private String idUser;
	private String firstname;
	private String lastname;
	private String login;
	private String password;
	private String email;
	private int age;
	private String weight;
	private String gender;
	private String photoURL;
	private String roleName;
	private String status;
	private int score;
	private GroupModel groups;
	
	//getters
	public String getIdUser() {
		return idUser;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public int getAge() {
		return age;
	}
	public String getWeight() {
		return weight;
	}
	public String getGender() {
		return gender;
	}
	public String getPhotoURL() {
		return photoURL;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getStatus() {
		return status;
	}
	public int getScore() {
		return score;
	}
	public GroupModel getGroups() {
		return groups;
	}
	
	//setters
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setPhotoURL(String photoURL) {
		this.photoURL = photoURL;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setGroups(GroupModel groups) {
		this.groups = groups;
	}
	
	
}
