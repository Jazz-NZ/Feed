package com.studentnetwork.feed.Feed;

import com.studentnetwork.feed.Feed.database.PostDB;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }


    public PostDB[] getJsonAsObject(int groupId) {
        String url = "http://localhost:8085/"+groupId;
        System.out.println();
        return this.restTemplate.getForObject(url, PostDB[].class);
    }

    public String getJsonAsString(){
        String url = "http://localhost:8083/post";
        return this.restTemplate.getForObject(url, String.class);
    }
}
