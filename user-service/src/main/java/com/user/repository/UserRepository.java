package com.user.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.objects.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
