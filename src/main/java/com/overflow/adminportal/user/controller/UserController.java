package com.overflow.adminportal.user.controller;

import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.organization.service.OrganizationService;
import com.overflow.adminportal.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    OrganizationService organizationService;

    @GetMapping
    public String getUsers(Model model) throws NotFoundException {

        model.addAttribute("users", userService.getAll());
        model.addAttribute("org", organizationService.getOrganization());
        return "user/index";
    }

    @GetMapping("/approved/{id}")
    public String userApproved(@PathVariable("id") Long id)
            throws NotFoundException {

        userService.approvedOrDisapproved(true, id);

        return "redirect:" + "/user";
    }


    @GetMapping("/disapproved/{id}")
    public String userDisapproved(@PathVariable("id") Long id)
            throws NotFoundException {

        userService.approvedOrDisapproved(false, id);

        return "redirect:" + "/user";
    }

    @GetMapping("/active/{id}")
    public String userActive(@PathVariable("id") Long id)
            throws NotFoundException {

        userService.activeOrInactive(true, id);

        return "redirect:" + "/user";
    }


    @GetMapping("/inactive/{id}")
    public String userInactive(@PathVariable("id") Long id)
            throws NotFoundException {

        userService.activeOrInactive(false, id);

        return "redirect:" + "/user";
    }

    @GetMapping("/view/{id}")
    public String productInactive(@PathVariable("id") Long id, Model model)
            throws NotFoundException {

        model.addAttribute("userResponseDTO", userService.findById(id));
        return "user/view";
    }

}
