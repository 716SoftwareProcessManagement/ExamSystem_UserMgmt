package edu.nju.softwareprocess.service;

import edu.nju.softwareprocess.entity.User;
import edu.nju.softwareprocess.exception.UserNotFoundException;
import edu.nju.softwareprocess.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Jerry Wang on 06/12/2017.
 */
@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Collection<User> getAllUsers() {
        Iterable<User> userIter = userRepository.findAll();
        ArrayList<User> userList = new ArrayList<User>();
        userIter.forEach(item -> {
            userList.add(item);
        });
        return userList;
    }

    public User getUserById(Long id) {
        User user = userRepository.findOne(id);
        if (user == null) {
            throw new UserNotFoundException(id);
        }
        return user;
    }


    public User addUser(User user) {
        return userRepository.save(user);

    }

    public User updateUser(User user) {
        getUserById(user.getId());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        getUserById(id);
        userRepository.delete(id);
    }

}
