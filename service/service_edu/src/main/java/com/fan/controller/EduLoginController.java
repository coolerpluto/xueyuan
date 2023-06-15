package com.fan.controller;

import com.fan.R;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/eduLogin")
@RestController
@CrossOrigin
public class EduLoginController {
    
    @PostMapping("/login")
    public R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        Map<String,Object> map = new HashMap<>();
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","");
    }
}
