package com.studentnetwork.feed.Feed;


import com.studentnetwork.feed.Feed.database.*;
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

    @Autowired
    private GroupRepository groupRepository;


    //treba da dobije userId i na osnovu toga da salje zahteve odredjenim grupama
    //{userId}
    @RequestMapping("/users/{userId}")
    public List<PostDB> getItem(@PathVariable("userId") String userid) {
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
       // groupMembershipRepository.findByMemberAccount(uid);

        List<GroupMembership> groupMembership = groupMembershipRepository.findByMemberAccount(uid);
       // List<GroupMembership> groups = groupMembership.map(Collections::singletonList).orElseGet(Collections::emptyList);

        for (GroupMembership group : groupMembership) {
            PostDB[] items = restService.getJsonAsObject(group.getGroupDbId());
            listToReturn.addAll(Arrays.asList(items));
        }

        return listToReturn;
    }


    @RequestMapping("/search/{groupName}")
    public List<GroupDB> getGroups(@PathVariable("groupName") String groupName) {

        Optional<GroupDB> groupDBOptional = groupRepository.findAllByGroupDbName(groupName);
        List<GroupDB> groups = groupDBOptional.map(Collections::singletonList).orElseGet(Collections::emptyList);

        return groups;

    }

    @RequestMapping("/join/{userID}/{groupID}")
    public String getMembership(@PathVariable("userID") String userID, @PathVariable("groupID") String groupID ){

        GroupMembership membership = new GroupMembership();
        membership.setMemberAccount(Integer.parseInt(userID));
        membership.setGroupDbId(Integer.parseInt(groupID));

        groupMembershipRepository.save(membership);

        System.out.println("membership saved");

        return "joined";
    }
}