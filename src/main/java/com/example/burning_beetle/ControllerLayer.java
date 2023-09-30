package com.example.burning_beetle;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ControllerLayer {
    ServiceLayer serviceLayerObj=new ServiceLayer();
    @PostMapping("/addUserInfo")
    public String addUserInfo(@RequestBody UserInfo obj){
        String ans=serviceLayerObj.addUser(obj);
        return ans;
    }


    @GetMapping("/findAllUser")
    public List<UserInfo> findAllUser(){
        List<UserInfo> ans=serviceLayerObj.findAllUser();
        return ans;
    }


    @GetMapping("/getUser/{greaterAge}/{lessThenAge}")
    public List<UserInfo> getUserAge(@PathVariable("greaterAge")Integer greaterAge,@PathVariable("lessThenAge")Integer lessThenAge){
        return serviceLayerObj.getUserAgeInServiceLayer(greaterAge,lessThenAge);
    }
}
