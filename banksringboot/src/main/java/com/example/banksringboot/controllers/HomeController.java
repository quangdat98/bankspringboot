package com.example.banksringboot.controllers;


import com.example.banksringboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    private AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        model.addAttribute("listAccount",accountService.listAccountBanks());
        return "home";
    }
}
