package com.example.banksringboot.services;

import com.example.banksringboot.entities.AccountBank;



public interface AccountService {
    Iterable<AccountBank> listAccountBanks();

    AccountBank savaAccount(AccountBank accountBank);

    void delete (Integer id);


    AccountBank findAccountByID(Integer id);

}
