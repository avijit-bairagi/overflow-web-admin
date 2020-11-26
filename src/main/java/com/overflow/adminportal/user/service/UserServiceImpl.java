package com.overflow.adminportal.user.service;

import com.overflow.adminportal.common.exception.NotFoundException;
import com.overflow.adminportal.common.utils.ObjectMapperUtils;
import com.overflow.adminportal.common.utils.ResponseStatus;
import com.overflow.adminportal.user.dto.UserResponseDTO;
import com.overflow.adminportal.user.entity.User;
import com.overflow.adminportal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public List<UserResponseDTO> getAll() {

        List<User> users = userRepository.findAll();

        return ObjectMapperUtils.mapAll(users, UserResponseDTO.class);
    }

    @Override
    public UserResponseDTO findById(Long userId) throws NotFoundException {
        return ObjectMapperUtils.map(findByUserId(userId), UserResponseDTO.class);
    }

    @Override
    public void approvedOrDisapproved(boolean isApproved, Long userId) throws NotFoundException {

        User user = findByUserId(userId);
        user.setApproved(isApproved);
        userRepository.save(user);
    }

    @Override
    public void activeOrInactive(boolean isActive, Long userId) throws NotFoundException {
        User user = findByUserId(userId);
        user.setActive(isActive);
        userRepository.save(user);
    }

    private User findByUserId(Long userId) throws NotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.NOT_FOUND.value(), ResponseStatus.NOT_FOUND.description()));
    }
}
