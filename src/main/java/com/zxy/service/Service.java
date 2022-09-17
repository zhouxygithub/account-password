package com.zxy.service;

import com.zxy.pojo.Account;

import java.util.List;

public interface Service {

    int addAccount(Account account);

    int delAccount(int id);

    int updateAccount(Account account);

    Account queryAccount(int id);

    List<Account> allAccount();
}
