package com.example.banksringboot.repositories;

import com.example.banksringboot.entities.AccountBank;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BankRepository extends CrudRepository<AccountBank,Integer> {
    @Query("select u from account_bank u where u.id = :id")
   AccountBank findOne(@Param("id") Integer id);


}
