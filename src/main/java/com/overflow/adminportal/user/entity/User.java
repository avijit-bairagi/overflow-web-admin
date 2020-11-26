package com.overflow.adminportal.user.entity;

import com.overflow.adminportal.common.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"})})
@Getter
@Setter
public class User extends BaseEntity {

    private String name;

    private String username;

    private String email;

    private String password;

    private boolean isApproved;

    private boolean isActive = true;
}