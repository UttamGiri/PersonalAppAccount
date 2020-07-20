package com.personal.api.account.ui.service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.personal.api.account.ui.data.AccountEntity;

import java.util.List;

public interface AccountService {
    List<AccountEntity> getAccounts(String userId);
}
