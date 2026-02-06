package com.pro.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.pro.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Garantir que o MySQL do Docker é usado
class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void deveSalvarEBuscarUsuario() {
        User user = new User(1L, "João da Silva", "joao.silva@exemplo.com", null);
        userRepository.save(user);

        Optional<User> result = userRepository.findById(user.getId());

        assertTrue(result.isPresent());
    }
}