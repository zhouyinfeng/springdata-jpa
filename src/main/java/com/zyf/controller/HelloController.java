package com.zyf.controller;

import com.zyf.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Value("${girl.cupSize}")
    private String cupSize;

    @Value("${spring.datasource.username}")
    private String userName;

    /*通过注册bean*/
    @Autowired
    private GirlProperties girlProperties;
    @GetMapping(value = "/hello/{id}")  //http://127.0.0.1:8082/hello/hello/14
    public  String  hello(@PathVariable("id") Integer id){
        return "id: "+id;
    }

    @GetMapping(value = "/hello")  //http://127.0.0.1:8082/hello/hello?id=100
    public  String  helloParam(@RequestParam(value = "id",required = false,defaultValue = "0") Integer id){
        return "id: "+id;
    }
    /*@RequestMapping(value = {"/hello","/hi"},method = RequestMethod.GET)
    public  String  hello(){
        return girlProperties.getCupSize();
    }*/
}
