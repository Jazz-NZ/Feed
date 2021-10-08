package com.studentnetwork.feed.Feed.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Integer> {

    List<GroupMembership> findByMemberAccount(int memberAccount);
}
