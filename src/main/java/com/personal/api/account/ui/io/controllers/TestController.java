package com.personal.api.account.ui.io.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class TestController {
	
    @GetMapping("/status/check")
    public String status() {
        return "Working..";
    }
	

}
