package com.personal.api.account.ui.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.personal.api.account.ui.data.AccountEntity;

@Service
public class AccountsServiceImpl implements AccountService {

    @Override
    public List<AccountEntity> getAccounts(String userId) {
        List<AccountEntity> returnValue = new ArrayList<>();
        
        AccountEntity albumEntity = new AccountEntity();
        albumEntity.setUserId(userId);
        albumEntity.setAccountId("account1Id");
        albumEntity.setDescription("account 1 description");
        albumEntity.setId(1L);
        albumEntity.setName("account 1 name");
        
        AccountEntity albumEntity2 = new AccountEntity();
        albumEntity2.setUserId(userId);
        albumEntity2.setAccountId("accountId");
        albumEntity2.setDescription("account 2 description");
        albumEntity2.setId(2L);
        albumEntity2.setName("account 2 name");
        
        returnValue.add(albumEntity);
        returnValue.add(albumEntity2);
        
        return returnValue;
    }
    
}
