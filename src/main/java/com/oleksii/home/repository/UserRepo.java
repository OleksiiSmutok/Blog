package com.oleksii.home.repository;

import com.oleksii.home.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
public interface UserRepo extends JpaRepository<User,Integer> {

  User findByLogin(String login);

  List<User> findAllByOrderByEmailAsc();

  User findByActivationKey(String activationKey);

}
