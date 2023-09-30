package com.example.burning_beetle;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {
    ReporesitoryLayer reporesitoryLayerObj=new ReporesitoryLayer();
    public String addUser(UserInfo userInfo){
        String ans=reporesitoryLayerObj.addUserToDb(userInfo);
        return ans;
    }

    public List<UserInfo> findAllUser(){
        return reporesitoryLayerObj.findUserInfoInDp();
    }

    public List<UserInfo> getUserAgeInServiceLayer(Integer greaterAge, Integer lessThenAge) {


        //first of all get the all user info from db and store it in list;
        //then apply filter to list to find such User;
        List<UserInfo> allUser=reporesitoryLayerObj.findUserInfoInDp();
        List<UserInfo> res=new ArrayList<>();
        for(UserInfo obj : allUser){
            if(obj.getAge()>=greaterAge && obj.getAge()<lessThenAge){
                res.add(obj);
            }
        }
        return res;
    }
}
