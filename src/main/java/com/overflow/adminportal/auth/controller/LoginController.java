package com.overflow.adminportal.auth.controller;

import com.overflow.adminportal.common.constant.RouteMappings;
import com.overflow.adminportal.auth.dto.request.LoginRequestDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @GetMapping(RouteMappings.LOGIN_URL)
    public String loginForm(LoginRequestDto loginRequestDto) {
    	System.out.println("yes - 1");
        return "login";
    }
/*
    @PostMapping(RouteMappings.LOGIN_URL)
    public String submitLoginForm(@Valid LoginRequestDto loginRequestDto, BindingResult bindingResult) {
    	System.out.println("yes - 2");
    	if (bindingResult.hasErrors()) {
            return "login";
        }
        return "redirect:/";
    }
*/
    @GetMapping(RouteMappings.LOGOUT_URL)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
    	System.out.println("yes - 3");
        return "redirect:" + RouteMappings.LOGIN_URL + "?logout";
    }
}
