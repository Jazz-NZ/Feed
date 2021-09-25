package com.studentnetwork.feed.Feed;

import java.util.List;

public class Group {

    private int groupId;
    private String groupName;
    private List<Post> groupPosts;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Post> getGroupPosts() {
        return groupPosts;
    }

    public void setGroupPosts(List<Post> groupPosts) {
        this.groupPosts = groupPosts;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public Group(int groupId, String groupName, List<Post> groupPosts) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupPosts = groupPosts;
    }
}
