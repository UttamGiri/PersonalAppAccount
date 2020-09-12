package com.personal.api.account.ui.io.controllers;



import java.util.ArrayList;
import java.util.List;

import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.api.account.ui.data.AccountEntity;
import com.personal.api.account.ui.service.AccountService;
import com.personal.api.account.ui.ui.model.AccountResponseModel;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
@RequestMapping("/users/{id}/accounts")
public class AccountController {
    
    @Autowired
    AccountService accountService;
    Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping( 
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public List<AccountResponseModel> userAlbums(@PathVariable String id) {

        List<AccountResponseModel> returnValue = new ArrayList<>();
        
        List<AccountEntity> accountEntities = accountService.getAccounts(id);
        
        if(accountEntities == null || accountEntities.isEmpty())
        {
            return returnValue;
        }
        
        Type listType = new TypeToken<List<AccountResponseModel>>(){}.getType();
 
        returnValue = new ModelMapper().map(accountEntities, listType);
        logger.info("Returning " + returnValue.size() + " accounts");
        return returnValue;
    }
    
    @GetMapping( value="/mono",
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public ResponseEntity<Mono<AccountResponseModel>> userAlbumsMono(@PathVariable String id) throws InterruptedException {
    	//Thread.sleep(7000);
Integer a =null;
int a1 = a+1;
    	Mono<AccountResponseModel> emps = accountService.getAccountMono(id);
        HttpStatus status = emps != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<AccountResponseModel>>(emps, status);
    }
    
    @GetMapping( value="/flux",
            produces = { 
                MediaType.APPLICATION_JSON_VALUE,
                MediaType.APPLICATION_XML_VALUE,
            })
    public ResponseEntity<Flux<AccountResponseModel>> userAlbumsFlux(@PathVariable String id) {

    	Flux<AccountResponseModel> emps = accountService.getAccountsFlux(id);
        HttpStatus status = emps != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Flux<AccountResponseModel>>(emps, status);
    }
    
//    Yes there is a difference between a flatmap and map.
//    flatMap should be used for non-blocking operations, or in short anything which returns back Mono,Flux.
//    map should be used when you want to do the transformation of an object /data in fixed time. The operations which are done synchronously.

}
