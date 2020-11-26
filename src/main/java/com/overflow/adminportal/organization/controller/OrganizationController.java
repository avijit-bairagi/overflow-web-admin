package com.overflow.adminportal.organization.controller;

import com.overflow.adminportal.common.constant.Constants;
import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.organization.dto.OrganizationRequestDTO;
import com.overflow.adminportal.organization.dto.OrganizationResponseDTO;
import com.overflow.adminportal.organization.service.OrganizationService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping
    public String getOrganizationList(Model model) {

        try {
            model.addAttribute("organization", organizationService.getOrganization());
        } catch (NotFoundException e) {
            model.addAttribute("organization", null);
        }

        return "organization/view";
    }

    @GetMapping("/edit")
    public String editOrganizationList(Model model) throws NotFoundException {

        model.addAttribute("organizationRequestDTO", organizationService.getOrganization());
        model.addAttribute("approvalTypes", Constants.APPROVAL_TYPES);
        model.addAttribute("orgTypes", Constants.ORG_TYPES);

        return "organization/edit";
    }

    @PostMapping("/edit")
    public String processEditOrganizationList(OrganizationRequestDTO organizationRequestDTO, BindingResult bindingResult, Model model) throws NotFoundException {

        if(bindingResult.hasErrors()) {
            model.addAttribute("approvalTypes", Constants.APPROVAL_TYPES);
            model.addAttribute("orgTypes", Constants.ORG_TYPES);
            return "organization/edit";
        }

        organizationService.update(organizationRequestDTO);

        return "redirect:/organization";
    }

    @GetMapping("/create")
    public String createOrganizationList(Model model, OrganizationRequestDTO organizationRequestDTO) {

        model.addAttribute("approvalTypes", Constants.APPROVAL_TYPES);
        model.addAttribute("orgTypes", Constants.ORG_TYPES);

        return "organization/create";
    }

}
