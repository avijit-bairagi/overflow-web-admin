package com.overflow.adminportal.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {

    Long Id;

    String name;

    String username;

    String email;

    boolean isApproved;

    boolean isActive;
}
