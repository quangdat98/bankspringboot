package com.example.banksringboot.services;

import com.example.banksringboot.entities.AccountBank;

public interface AccountService {
    Iterable<AccountBank> listAccountBanks();
}
