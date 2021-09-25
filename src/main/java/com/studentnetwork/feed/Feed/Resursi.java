package com.studentnetwork.feed.Feed;


import com.studentnetwork.feed.Feed.database.GroupMembership;
import com.studentnetwork.feed.Feed.database.GroupMembershipRepository;
import com.studentnetwork.feed.Feed.database.PostDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@CrossOrigin("*") // because acces controll allow origin error
@RestController
@RequestMapping("/")
@Controller
public class Resursi {

    @Autowired
    private RestService restService;

    @Autowired
    private GroupMembershipRepository groupMembershipRepository;


    //treba da dobije userId i na osnovu toga da salje zahteve odredjenim grupama
    //{userId}
    @RequestMapping("/{userId}")
    public List<PostDB> getItem(@PathVariable("userId") String userid){
/*
        return Collections.singletonList( new ResItem("Nikola","Zivanovic",
                Arrays.asList(new Group(1,"Matematika 1", "FON","Beogradski"),
                        new Group(2,"Programski jezici", "FON","Beogradski"),
                        new Group(3,"Statistika", "FON","Beogradski"))));*/



       // ResItem[] items = restService.getJsonAsObject();
        LinkedList<PostDB> listToReturn = new LinkedList<>();
/*
        GroupMembership membership = new GroupMembership();
        membership.setMemberAccount(1);
        membership.setGroupDbId(36);

        groupMembershipRepository.save(membership);*/

        int uid = Integer.parseInt(userid);
        groupMembershipRepository.findByMemberAccount(uid);

        Optional<GroupMembership> groupMembership = groupMembershipRepository.findByMemberAccount(uid);
        List<GroupMembership> groups = groupMembership.map(Collections::singletonList).orElseGet(Collections::emptyList);

        for (GroupMembership group : groups) {
            PostDB[] items = restService.getJsonAsObject(group.getGroupDbId());
            listToReturn.addAll(Arrays.asList(items));
        }

        return listToReturn;
    }





}
