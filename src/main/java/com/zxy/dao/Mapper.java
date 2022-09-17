package com.zxy.dao;

import com.zxy.pojo.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface Mapper {

    int addAccount(Account account);

    int delAccount(@Param("id") int id);

    int updateAccount(Account account);

    Account queryAccount(@Param("id") int id);

    List<Account> allAccount();
}
