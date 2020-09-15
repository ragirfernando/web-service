package com.webservice.webservice.config;

import com.webservice.webservice.domain.Order;
import com.webservice.webservice.domain.User;
import com.webservice.webservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        List<Order> order = new ArrayList<>();

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456", order);
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456", order);
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
