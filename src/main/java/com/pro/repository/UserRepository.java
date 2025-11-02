package com.pro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}