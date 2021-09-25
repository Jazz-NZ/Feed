package com.studentnetwork.feed.Feed.database;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupMembershipRepository extends JpaRepository<GroupMembership, Integer> {

    Optional<GroupMembership> findByMemberAccount(int memberAccount);
}
