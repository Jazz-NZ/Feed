package com.studentnetwork.feed.Feed.database;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<GroupDB,Integer> {


    Optional<GroupDB> findAllByGroupDbName(String groupName);
}
