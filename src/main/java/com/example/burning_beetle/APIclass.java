package com.example.burning_beetle;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
public class APIclass {

    HashMap<Integer,UserInfo> userInfoDb=new HashMap<Integer, UserInfo>();

    @PostMapping("/addUser")
    public String addUserToDb(@RequestParam("userId")Integer userId,
                              @RequestParam("name")String name,
                              @RequestParam("age")Integer age,
                              @RequestParam("emailId")String emailId){
        UserInfo obj=new UserInfo(name,age,emailId,userId);
        userInfoDb.put(userId,obj);
        return "data added to database";
    }

    @PostMapping("/addingUserByRequestBody")
    public String addingUserByBody(@RequestBody UserInfo obj){
        int key=obj.getUserId();
        userInfoDb.put(key,obj);
        return "data added to db";
    }



    @GetMapping("/getUser/{userId}")
    public UserInfo getUserInfo(@PathVariable("userId")Integer userId){
         UserInfo response=userInfoDb.get(userId);
         return response;
    }


    @GetMapping("/userInfo/{greaterAge}/{lessThenAge}")
    public  List<UserInfo> userInfo(@PathVariable("greaterAge")Integer greaterAge,@PathVariable("lessThenAge")Integer lessThenAge){
        List<UserInfo> res=new ArrayList<>();
        for(UserInfo obj:userInfoDb.values()){
            if(obj.getAge()>=greaterAge && obj.getAge()<= lessThenAge){
                res.add(obj);
            }
        }
        return res;
    }
    @GetMapping("/getUserInfoByUserId")

    public UserInfo getUserInfoByUserId(@RequestParam("userId")Integer userId){
          UserInfo response=userInfoDb.get(userId);
          return response;
    }

    @GetMapping("/forAllUser")

    public List<UserInfo> forAllUser(){

        List<UserInfo> res=new ArrayList<>();
        for(UserInfo obj: userInfoDb.values()){
            res.add(obj);
        }
        return res;
    }

    @GetMapping("/onlyName")

    public List<String> onlyName(){
        List<String> res=new ArrayList<>();
        for(UserInfo obj : userInfoDb.values()){
            res.add(obj.getName());
        }
        return res;
    }

}
