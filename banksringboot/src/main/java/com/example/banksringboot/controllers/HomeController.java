package com.example.banksringboot.controllers;


import com.example.banksringboot.entities.AccountBank;
import com.example.banksringboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    /* add new account start*/

    @RequestMapping("/accout/new")
    public String getFormAccout(Model model){
        model.addAttribute("accountObject",new AccountBank());
        return "forminput";
    }
    @PostMapping("/acountURL")
    public String getAccout(AccountBank accountBank){
        accountService.savaAccount(accountBank);
        return "redirect:/";
    }

    /*add new account end*/

    /*delete account*/

    @GetMapping("/account/delete/{idC}")
    public String delete(@PathVariable Integer idC){
        accountService.delete(idC);
        return "redirect:/";
    }
}
