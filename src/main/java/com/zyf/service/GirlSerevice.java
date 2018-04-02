package com.zyf.service;

import com.zyf.domain.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GirlSerevice {
    @Autowired
    private GirlRespository girlRespository;

    //同時成功 一個失敗都失敗  只有查詢的時候不需要加事務
    @Transactional
    public void insertTwo(){
        Girl girl1 = new Girl();
        girl1.setAge(17);
        girl1.setCupSize("36");
        girlRespository.save(girl1);
        Girl girl2 = new Girl();
        girl2.setAge(17);
        girl2.setCupSize("36");
        girlRespository.save(girl2);
    }
}
