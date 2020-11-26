package com.overflow.adminportal.organization.entity;

import com.overflow.adminportal.common.entity.BaseEntity;
import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "config")
public class Organization extends BaseEntity {

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

	boolean isApprovalNeeded;

}
