package com.mycompany.mywebbapp;

import com.mycompany.mywebbapp.user.User;
import com.mycompany.mywebbapp.user.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository repository;

    @Test
    public void testAddNew() {
        User user = new User();
        user.setEmail("cycy.doll@test.fr");
        user.setPassword("switch");
        user.setFirstName("cylia");
        user.setLastName("dollou");

        User savedUser = repository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(savedUser.getId()).isGreaterThan(0);

    }

    @Test
    public void testListAll() {
        Iterable<User> users = repository.findAll();

        assertThat(users).hasSizeGreaterThan(0);

        for (User user : users) {
            System.out.println(user.getLastName());
        }

    }

    @Test
    public void testUpdate() {
        Integer userId = 1;
        Optional<User> optionalUser = repository.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello2000");
        repository.save(user);

        User updatedUser = repository.findById(userId).get();
        assertThat(updatedUser.getPassword()).isEqualTo("hello2000");
    }

    @Test
    public void testGet() {
        Integer userId = 2;
        Optional<User> optionalUser = repository.findById(userId);
        assertThat(optionalUser).isPresent();
        System.out.println(optionalUser);
    }

    @Test
    public void testDelete() {
        Integer userId = 2;
        repository.deleteById(userId);

        Optional<User> optionalUser = repository.findById(userId);
        assertThat(optionalUser).isNotPresent();

    }
}
