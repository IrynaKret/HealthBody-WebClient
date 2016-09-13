package edu.softserveinc.healthbody.webclient.wrapperD;

import java.util.ArrayList;
import java.util.List;

import edu.softserveinc.healthbody.webclient.healthbody.webservice.GroupDTO;

public class UserDTORest {

    private String age;
    private String email;
    private String firstname;
    private String gender;
    private String googleApi;
    private List<GroupDTO> groups;
    private String health;
    private String idUser;
    private String isDisabled;
    private String lastname;
    private String login;
    private String password;
    private String photoURL;
    private String roleName;
    private String score;
    private String status;
    private String weight;
  


    public void setGroups(List<GroupDTO> groups) {
		this.groups = groups;
	}

	public void setHealth(String health) {
		this.health = health;
	}

	public String getAge() {
        return age;
    }

    public void setAge(String value) {
        this.age = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String value) {
        this.firstname = value;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String value) {
        this.gender = value;
    }

    public String getGoogleApi() {
        return googleApi;
    }

    public void setGoogleApi(String value) {
        this.googleApi = value;
    }

    public List<GroupDTO> getGroups() {
        if (groups == null) {
            groups = new ArrayList<GroupDTO>();
        }
        return this.groups;
    }

    public String getHealth() {
        return health;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String value) {
        this.idUser = value;
    }


    public String getIsDisabled() {
        return isDisabled;
    }


    public void setIsDisabled(String value) {
        this.isDisabled = value;
    }


    public String getLastname() {
        return lastname;
    }


    public void setLastname(String value) {
        this.lastname = value;
    }


    public String getLogin() {
        return login;
    }


    public void setLogin(String value) {
        this.login = value;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String value) {
        this.password = value;
    }


    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String value) {
        this.photoURL = value;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String value) {
        this.roleName = value;
    }


    public String getScore() {
        return score;
    }


    public void setScore(String value) {
        this.score = value;
    }

    public String getStatus() {
        return status;
    }


    public void setStatus(String value) {
        this.status = value;
    }


    public String getWeight() {
        return weight;
    }
  

    public void setWeight(String value) {
        this.weight = value;
    }

}

