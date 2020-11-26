package com.overflow.adminportal.organization.service;

import com.overflow.adminportal.common.exception.AlreadyExistsException;
import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.organization.dto.OrganizationRequestDTO;
import com.overflow.adminportal.organization.dto.OrganizationResponseDTO;
import com.overflow.adminportal.organization.exception.OrganizationNotFoundException;

public interface OrganizationService {

    OrganizationResponseDTO save(OrganizationRequestDTO organization) throws AlreadyExistsException;

    OrganizationResponseDTO update(OrganizationRequestDTO organization) throws OrganizationNotFoundException;

    OrganizationResponseDTO getOrganization() throws NotFoundException;


}
