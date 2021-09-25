package com.studentnetwork.feed.Feed.database;

import javax.persistence.*;

@Entity
@Table(name = "GroupDB")
public class GroupDB {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int groupDbId;
    private String groupDbName;


    public int getGroupDbId() {
        return groupDbId;
    }

    public void setGroupDbId(int groupId) {
        this.groupDbId = groupId;
    }

    public String getGroupName() {
        return groupDbName;
    }

    public void setGroupName(String groupName) {
        this.groupDbName = groupName;
    }
}
