package com.example.banksringboot.services;

import com.example.banksringboot.entities.AccountBank;
import com.example.banksringboot.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceIpml implements AccountService {

    private BankRepository bankRepository;
    @Autowired
    private void setBankRepository(BankRepository bankRepository){
        this.bankRepository=bankRepository;
    }

    @Override
    public Iterable<AccountBank> listAccountBanks() {
        return bankRepository.findAll();
    }
}
