package edu.softserveinc.healthbody.webclient.wrapperD;

import java.util.ArrayList;
import java.util.List;

public class GroupDTORest {

    private String count;
    private String descriptions;
    private List<String> firstname;
    private String idGroup;
    private List<String> lastname;
    private String name;
    private String scoreGroup;
    private String status;
    private List<String> users;

    
    public String getCount() {
        return count;
    }

    public void setCount(String value) {
        this.count = value;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String value) {
        this.descriptions = value;
    }

    public List<String> getFirstname() {
        if (firstname == null) {
            firstname = new ArrayList<String>();
        }
        return this.firstname;
    }


    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String value) {
        this.idGroup = value;
    }

    public List<String> getLastname() {
        if (lastname == null) {
            lastname = new ArrayList<String>();
        }
        return this.lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }

    public String getScoreGroup() {
        return scoreGroup;
    }

    public void setScoreGroup(String value) {
        this.scoreGroup = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        this.status = value;
    }

    public List<String> getUsers() {
        if (users == null) {
            users = new ArrayList<String>();
        }
        return this.users;
    }

}


