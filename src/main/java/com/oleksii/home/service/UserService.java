package com.oleksii.home.service;

import com.oleksii.home.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by Admin on 27.04.2017.
 */
public interface UserService {

    public  void  add(User user);

    public  void  delete(int id);

    public  User  find(int id);

    public  void  edit(int id,String firstName,String secondName,String email,String phone,String login,String password,MultipartFile pathToPhoto);

    public void activate(String activationKey);

    public List<User> findAll();

    public  User  findByLogin(String login);

    public void addPhoto(User user,MultipartFile photo);

    List<User> finAllOrderedByEmailAsc();

}
