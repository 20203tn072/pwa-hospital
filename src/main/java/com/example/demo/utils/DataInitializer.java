package com.example.demo.utils;


import com.example.demo.User.Entity.User;
import com.example.demo.User.Service.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(Repository repository) {
        return args -> {
            // Verificar si existe el usuario 'isla'
            User existingUser = repository.findByUsername("isla");

            if (existingUser == null) {
                User newUser = new User();
                newUser.setUsername("island");
                // Contraseña "12345" encriptada con BCrypt
                newUser.setPassword("123");
                newUser.setRole("island");
                newUser.setNeedAuthentication(true); // O true, según prefieras, pero dijiste 0

                repository.save(newUser);
                System.out.println(">> USUARIO 'isla' CREADO AUTOMÁTICAMENTE");
            } else {
                System.out.println(">> USUARIO 'isla' YA EXISTE. NO SE HICIERON CAMBIOS.");
            }
        };
    }
}
