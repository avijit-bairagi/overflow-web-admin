package com.overflow.adminportal.user.service;


import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.user.dto.UserResponseDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAll();

    UserResponseDTO findById(Long userId) throws NotFoundException;

    void approvedOrDisapproved(boolean isApproved, Long userId) throws NotFoundException;

    void activeOrInactive(boolean isActive, Long userId) throws NotFoundException;
}
