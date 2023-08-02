package edu.mx.utvt.examenfinal.mokito;

import edu.mx.utvt.examenfinal.data.UserData;
import edu.mx.utvt.examenfinal.entities.User;
import edu.mx.utvt.examenfinal.repos.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@Slf4j
@AutoConfigureMockMvc
public class UserMockTest {
    @Mock
    private UserRepository userRepository;

    @Test
    void getAllUsers(){
        List<User> userList = null;
        when(this.userRepository.findAll()).thenReturn(UserData.showAll());
        userList = this.userRepository.findAll();
        verify(this.userRepository).findAll();
        Assertions.assertNotNull(userList);
    }

    @Test
    void findPatientById(){
        Optional<User> patientOptional = null;

        when(this.userRepository.findById(1L)).thenReturn(UserData.showOne(1L));

        patientOptional = this.userRepository.findById(1L);

        Assertions.assertEquals(patientOptional.get().getId(), 1L);

        verify(this.userRepository).findById(1L);
    }

    @Test
    void createUserMockTest(){
        User user = null;
        user = User.builder().nombre("Cristian").apellidos("Rubi Cirilo").matricula(222011226).build();
        when(this.userRepository.save(user)).thenReturn(UserData.newUser(user));
        user = this.userRepository.save(user);

        Assertions.assertNotNull(user);
    }
}
