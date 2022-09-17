package com.zxy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zxy.pojo.Account;
import com.zxy.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @ClassName Controller
 * @Author zxy
 * @Date 2022/9/15 11:32
 **/
@Controller
public class InformationController {

    @Autowired
    @Qualifier("ServiceImpl")
    private ServiceImpl service;
    JSONObject jsonObject = new JSONObject();

    public String main(){
        return "main";
    }

    @RequestMapping("toAddAccount")
    public String toAddAccount(){
        return "addAccount";
    }
    @ResponseBody
    @RequestMapping("addAccount")
    public String addAccount(Account account){
        if(account.getType().equals("software")){
            account.setType("软件");
        }else if (account.getType().equals("url")){
            account.setType("网站");
        }else{
            account.setType("其他");
        }
        int i = service.addAccount(account);
        if(i > 0){
            jsonObject.put("code",200);
            jsonObject.put("msg","添加成功");
        }else{
            jsonObject.put("code",201);
            jsonObject.put("msg","添加失败");
        }
        return JSON.toJSONString(jsonObject);
    }

    @RequestMapping("main")
    public String allAccount(Model model){
        List<Account> accounts = service.allAccount();
        System.out.println(accounts);
        model.addAttribute("accounts",accounts);
        return "main";
    }
    @RequestMapping("toUpdateAccount/{id}")
    public String toUpdateAccount(@PathVariable("id") int id,Model model){
        System.out.println("修改的id为："+id);
        Account account = service.queryAccount(id);
        model.addAttribute("account",account);
        return "updateAccount";
    }
    @ResponseBody
    @RequestMapping("updateAccount")
    public String updateAccount(Account account){
        System.out.println("修改后的账号信息："+account);
        if (account.getType().equals("software")){
            account.setType("软件");
        }else if (account.getType().equals("url")){
            account.setType("网站");
        }else{
            account.setType("其他");
        }
        System.out.println("修改后的账号信息1："+account);
        int i = service.updateAccount(account);
        if(i > 0){
            jsonObject.put("code",200);
            jsonObject.put("msg","添加成功");
        }else{
            jsonObject.put("code",201);
            jsonObject.put("msg","添加失败");
        }
        return JSON.toJSONString(jsonObject);
    }
}






















