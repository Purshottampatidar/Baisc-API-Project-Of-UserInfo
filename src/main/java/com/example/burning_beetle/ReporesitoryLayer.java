package com.example.burning_beetle;

import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ReporesitoryLayer {
    Map<Integer,UserInfo> userInfoDb=new HashMap<>();

    public String addUserToDb(UserInfo userInfo){
        int key=userInfo.getUserId();
        userInfoDb.put(key,userInfo);
        return "user Added to Database";
    }


    public List<UserInfo> findUserInfoInDp() {
        return userInfoDb.values().stream().toList();
    }


}

