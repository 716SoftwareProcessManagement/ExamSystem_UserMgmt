package edu.nju.softwareprocess.repository;

import edu.nju.softwareprocess.entity.User;
import org.springframework.data.repository.CrudRepository;



/**
 * Created by Jerry Wang on 06/12/2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {

}