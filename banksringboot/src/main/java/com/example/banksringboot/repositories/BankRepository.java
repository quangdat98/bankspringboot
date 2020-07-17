package com.example.banksringboot.repositories;

import com.example.banksringboot.entities.AccountBank;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BankRepository extends CrudRepository<AccountBank,Integer> {

}
