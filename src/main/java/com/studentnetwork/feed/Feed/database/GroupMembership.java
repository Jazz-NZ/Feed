package com.studentnetwork.feed.Feed.database;

import javax.persistence.*;

@Entity
@Table(name = "GroupMembership")
public class GroupMembership {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int membershipId;
    private int groupDbId;
    //userId
    private int memberAccount;

    public int getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(int membershipId) {
        this.membershipId = membershipId;
    }

    public int getGroupDbId() {
        return groupDbId;
    }

    public void setGroupDbId(int groupDbId) {
        this.groupDbId = groupDbId;
    }

    public int getMemberAccount() {
        return memberAccount;
    }

    public void setMemberAccount(int memberAccount) {
        this.memberAccount = memberAccount;
    }
}
