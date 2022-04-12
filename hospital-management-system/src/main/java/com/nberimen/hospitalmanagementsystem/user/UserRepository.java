package com.nberimen.hospitalmanagementsystem.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByIdentityNo(Long identityNo);
}
