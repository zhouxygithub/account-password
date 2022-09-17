package com.zxy.service;

import com.zxy.dao.Mapper;
import com.zxy.pojo.Account;

import java.util.List;

/**
 * @ClassName ServiceImpl
 * @Author zxy
 * @Date 2022/9/15 11:28
 **/
public class ServiceImpl implements Service{

    private Mapper mapper;

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public int addAccount(Account account) {
        return mapper.addAccount(account);
    }

    public int delAccount(int id) {
        return mapper.delAccount(id);
    }

    public int updateAccount(Account account) {
        return mapper.updateAccount(account);
    }

    public Account queryAccount(int id) {
        return mapper.queryAccount(id);
    }

    public List<Account> allAccount() {
        return mapper.allAccount();
    }
}
