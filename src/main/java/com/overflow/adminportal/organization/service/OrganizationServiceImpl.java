package com.overflow.adminportal.organization.service;

import com.overflow.adminportal.common.constant.Constants;
import com.overflow.adminportal.common.exception.AlreadyExistsException;
import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.common.utils.ObjectMapperUtils;
import com.overflow.adminportal.common.utils.ResponseStatus;
import com.overflow.adminportal.organization.dto.OrganizationRequestDTO;
import com.overflow.adminportal.organization.dto.OrganizationResponseDTO;
import com.overflow.adminportal.organization.entity.Organization;
import com.overflow.adminportal.organization.exception.OrganizationNotFoundException;
import com.overflow.adminportal.organization.repository.OrganizationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public OrganizationResponseDTO save(OrganizationRequestDTO organizationRequestDTO) throws AlreadyExistsException {

        Organization organization = modelMapper.map(organizationRequestDTO, Organization.class);

        if(organizationRequestDTO.getApprovalType().equalsIgnoreCase("Need"))
            organization.setApprovalNeeded(true);
        else
            organization.setApprovalNeeded(false);

        organizationRepository.save(organization);
        return null;
    }

    @Override
    public OrganizationResponseDTO update(OrganizationRequestDTO organizationRequestDTO) throws OrganizationNotFoundException {

        Organization organization = modelMapper.map(organizationRequestDTO, Organization.class);

        if(organizationRequestDTO.getApprovalType().equalsIgnoreCase("Need"))
            organization.setApprovalNeeded(true);
        else
            organization.setApprovalNeeded(false);

        organizationRepository.save(organization);

        return null;
    }

    @Override
    public OrganizationResponseDTO getOrganization() throws NotFoundException {

        List<Organization> organizationList = organizationRepository.findAll();

        if (organizationList.isEmpty())
            throw new NotFoundException(ResponseStatus.NOT_FOUND.value(), ResponseStatus.NOT_FOUND.description());

        OrganizationResponseDTO organizationResponseDTO = ObjectMapperUtils.map(organizationList.get(0), OrganizationResponseDTO.class);

        if (organizationResponseDTO.isApprovalNeeded())
            organizationResponseDTO.setApprovalType("Need");
        else
            organizationResponseDTO.setApprovalType("Not need");

        return organizationResponseDTO;
    }
}
