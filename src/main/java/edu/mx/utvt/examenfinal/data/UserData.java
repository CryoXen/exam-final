package edu.mx.utvt.examenfinal.data;

import edu.mx.utvt.examenfinal.entities.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserData {
    public static User newUser(User user){
        return User.builder().id(user.getId()).nombre(user.getNombre()).apellidos(user.getApellidos()).matricula(user.getMatricula()).build();
    }

    public static Optional<User> showOne(Long id) {
        Optional<User> optionalUser = Optional.of(User.builder().id(id).nombre("Cristian").apellidos("Rubi Cirilo").matricula(123456789).build());
        return optionalUser;
    }

    public static List<User> showAll() {
        List<User> userList = null;

        userList = new ArrayList<>();
        userList.add(User.builder().nombre("Cristian").apellidos("Rubi Cirilo").matricula(123456789).build());
        return  userList;
    }
}
