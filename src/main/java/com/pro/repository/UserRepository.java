package com.pro.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pro.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Consulta para filtrar usuários com mais de 18 anos
    List<User> findByBirthDateBefore(LocalDate date);
}