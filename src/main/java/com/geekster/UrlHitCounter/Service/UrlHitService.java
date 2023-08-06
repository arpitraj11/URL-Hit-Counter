package com.geekster.UrlHitCounter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UrlHitService {

    //@Autowired
    public Integer hitCount=0;

    HashMap<String, Integer> userHitCounts = new HashMap<>();

    public int incrementHitCount() {
        return hitCount++;
    }

    public void incrementUserHitCount(String username) {
        int userHitCount = userHitCounts.getOrDefault(username, 0);
        userHitCount++;
        userHitCounts.put(username, userHitCount);
        hitCount++;
    }

    public Integer getUserHitCounter(String username) {
        incrementUserHitCount(username);
        return userHitCounts.get(username);

    }

}
