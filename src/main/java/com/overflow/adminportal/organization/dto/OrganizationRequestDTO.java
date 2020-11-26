package com.overflow.adminportal.organization.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrganizationRequestDTO {

    Long id;

    String appName;

    String nameEn;

    String nameBn;

    String type;

    String addressLine;

    String city;

    String logo;

    String domain;

    String apiEndPoint;

    String phoneNo;

    String email;

    String fax;

    String approvalType;

}
