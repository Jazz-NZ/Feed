package com.studentnetwork.feed.Feed;

import java.util.List;

public class ResItem {

    private String name;
    private String surname;



    private List<Group> groups;

    public ResItem(String name, String surname, List<Group> groups) {
        this.name = name;
        this.surname = surname;
        this.groups = groups;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }


}
