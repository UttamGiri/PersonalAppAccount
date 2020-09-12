package com.personal.api.account.ui.service;

import java.lang.reflect.Type;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import com.personal.api.account.ui.data.AccountEntity;
import com.personal.api.account.ui.ui.model.AccountResponseModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    
    
    private AccountEntity getAccount(String userId) {
    	 AccountEntity albumEntity = new AccountEntity();
         albumEntity.setUserId(userId);
         albumEntity.setAccountId("Single mono account1Id");
         albumEntity.setDescription("account 1 description");
         albumEntity.setId(1L);
         albumEntity.setName("account 1 name");
         
         return albumEntity;
    }

	@Override
	public Flux<AccountResponseModel> getAccountsFlux(String userId) {
		
		 Type listType = new TypeToken<List<AccountResponseModel>>(){}.getType();
		 
		
		List<AccountResponseModel> listResponseModel = new ModelMapper().map(getAccounts(userId), listType);
		
		Flux<AccountResponseModel> list = Flux.fromIterable(listResponseModel);
		list.toStream().forEach((s) -> {s.setAccountId(s.getAccountId() + " flux");});
		return list;
	}

	@Override
	public Mono<AccountResponseModel> getAccountMono(String userId) {
		
		AccountResponseModel accountResponseModel = new ModelMapper().map(getAccount(userId), AccountResponseModel.class);

		return  Mono.justOrEmpty(accountResponseModel);
	}
    
}
