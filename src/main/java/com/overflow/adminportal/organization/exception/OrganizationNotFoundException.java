package com.overflow.adminportal.organization.exception;

import com.overflow.adminportal.common.exception.NotFoundException;

public class OrganizationNotFoundException extends NotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public OrganizationNotFoundException(String arg) {
		super(arg, null);
	}

}
