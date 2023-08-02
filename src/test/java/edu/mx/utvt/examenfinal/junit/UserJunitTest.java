package edu.mx.utvt.examenfinal.junit;

import edu.mx.utvt.examenfinal.entities.User;
import edu.mx.utvt.examenfinal.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@Slf4j
public class UserJunitTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void getAllUsers(){
        List<User> userList = this.userRepository.findAll();

        Assertions.assertNotNull(userList);

        for (User user : userList) {
            log.info("ID: " + user.getId());
            log.info("Nombre: " + user.getNombre() + " " + user.getApellidos());
        }
    }
    
    @Test
    void createUserJUnitTest(){
        User user = null;
        user = this.userRepository.save(User.builder().nombre("Cristian").apellidos("Rubi Cirilo").matricula(222011226).build());
        Assertions.assertNotNull(user);
    }

    @Test
    void updateUserJUnitTest(){
        Optional<User> optionalUser = this.userRepository.findById(1L);
        Assertions.assertTrue(optionalUser.isPresent());

        User user = optionalUser.get();

        user.setApellidos("Rubi");

        Assertions.assertEquals("Rubi", user.getApellidos());
        log.info(user.toString());
    }

    @Test
    void deleteUserJunitTest(){
        Optional<User> optionalUser = this.userRepository.findById(1L);
        Assertions.assertTrue(optionalUser.isPresent());

        User user = optionalUser.get();
        this.userRepository.delete(user);
    }
}
