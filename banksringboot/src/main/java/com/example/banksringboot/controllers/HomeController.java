package com.example.banksringboot.controllers;


import com.example.banksringboot.entities.AccountBank;
import com.example.banksringboot.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private AccountService accountService;
    @Autowired
    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping("/")
    public String getHome(Model model){
        model.addAttribute("objectAccount",new AccountBank());
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



    /* delete account start*/

    @GetMapping("/account/delete/{idC}")
    public String delete(@PathVariable Integer idC){
        accountService.delete(idC);
        return "redirect:/";
    }


    /* delete account end */


    /* edit account start */

    @GetMapping(value = "/account/edit/{id}")
    public String edit(ModelMap modelMap, @PathVariable Integer id){
        modelMap.addAttribute("accountEdit",accountService.findAccountByID(id));
        return "accountshow";
    }

    @PostMapping("/acountEdit")
    public String getAccoutEdit(AccountBank accountBank){
        accountService.savaAccount(accountBank);
        return "redirect:/";
    }

    /* edit account end */

    @GetMapping("/findId")
    public String getFindId(@RequestParam int id,ModelMap model){
        model.addAttribute("listAccount",accountService.findAccountByID(id));
        return "home";
    }
}
