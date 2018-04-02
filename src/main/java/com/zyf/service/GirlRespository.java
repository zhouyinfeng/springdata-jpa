package com.zyf.service;

import com.zyf.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRespository extends JpaRepository<Girl,Integer>{
    //通過年齡查詢
    public List<Girl> findByAge(Integer age);
}
