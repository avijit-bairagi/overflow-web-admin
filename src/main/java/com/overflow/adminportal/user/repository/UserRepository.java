package com.overflow.adminportal.user.repository;


import com.overflow.adminportal.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    User save(User user);

    @Override
    Optional<User> findById(Long aLong);
}
