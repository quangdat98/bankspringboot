package com.example.banksringboot.services;

import com.example.banksringboot.entities.AccountBank;
import com.example.banksringboot.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


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

    @Override
    public AccountBank savaAccount(AccountBank accountBank) {
        return bankRepository.save(accountBank);
    }

    @Override
    public void delete(Integer id) {
        bankRepository.deleteById(id);
    }

    @Override
    public AccountBank findAccountByID(Integer id) {
        return (AccountBank) bankRepository.findOne(id);
    }


}
