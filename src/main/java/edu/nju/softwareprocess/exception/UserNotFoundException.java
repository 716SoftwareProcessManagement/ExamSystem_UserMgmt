package edu.nju.softwareprocess.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Jerry Wang on 06/12/2017.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long userId) {
        super("could not find user with id '" + userId + "'.");
    }

    public UserNotFoundException(String userName) {
        super("could not find user named '" + userName + "'.");
    }
}