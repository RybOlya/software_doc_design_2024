package ua.lviv.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.iot.model.User;
import ua.lviv.iot.repository.UserRepository;

import java.util.Date;

@Service
public class UserService extends AbstractService<User> {

    @Autowired
    public UserService(UserRepository userRepository) {
        super(userRepository);
    }

    @Override
    public User mapCsvToObject(String[] objectCsv) {
        String id = objectCsv[0];
        String username = objectCsv[1];
        String email = objectCsv[2];

        return new User(username, email);
    }
}
