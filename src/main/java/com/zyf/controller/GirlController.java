package com.zyf.controller;

import com.zyf.domain.Girl;
import com.zyf.service.GirlRespository;
import com.zyf.service.GirlSerevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GirlController {

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlSerevice girlSerevice;

    @GetMapping(value = "/girls")
    public List<Girl> girlLists() {
    return  girlRespository.findAll();
    }

    @PostMapping(value = "/addGirls")
    public Girl addGirls(@RequestParam("cupSize") String cupSize,
                         @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRespository.save(girl);
    }

    @GetMapping(value = "/girls/{id}")
    public Optional<Girl> girlFindOne(@PathVariable("id") Integer id){
       return girlRespository.findById(id);
    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleted(@PathVariable("id") Integer id){
        girlRespository.deleteById(id);
    }

    @PostMapping(value = "/update/{id}")
    public Girl update(@PathVariable("id")Integer id,@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRespository.save(girl);
    }

   //通過年齡查詢
    @GetMapping(value = "/queryByAge/{age}")
    public List<Girl> girlByGirl(@PathVariable("age")Integer age){
        return girlRespository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlSerevice.insertTwo();
    }
}
