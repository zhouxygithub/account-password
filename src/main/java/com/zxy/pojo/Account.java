package com.zxy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName accountPwd
 * @Author zxy
 * @Date 2022/9/15 11:16
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private int id;
    private String type;
    private String name;
    private String account;
    private String password;
    private String remark;
}
