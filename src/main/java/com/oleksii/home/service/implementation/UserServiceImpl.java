package com.oleksii.home.service.implementation;

import com.oleksii.home.entity.User;
import com.oleksii.home.repository.UserRepo;
import com.oleksii.home.service.UserService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Admin on 28.04.2017.
 */
@Service
public class UserServiceImpl implements UserService,UserDetailsService {

    @Autowired
    private  UserRepo userRepo;

    @Override
    public void add(User user) {
        user.setActivationKey(RandomStringUtils.randomAlphabetic(20));
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("yulian.bulbuk.logos@gmail.com", "qwertyuiop[]");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(user.getEmail()));
            message.setSubject("Activate your account");
            message.setText("http://localhost:8080/activate/"+user.getActivationKey());

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        userRepo.save(user);
    }

    @Override
    public void addPhoto(User user,MultipartFile photo) {
        double random = Math.random()*5000;
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Blog\\src\\main\\webapp\\resources\\img\\"+random+"."+photo.getContentType().split("/")[1]);

        try {
            file.createNewFile();
            photo.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        user.setPathToPhoto(random+"."+photo.getContentType().split("/")[1]);
        userRepo.save(user);
    }

    @Override
    public List<User> finAllOrderedByEmailAsc() {
        return null;
    }

    @Override
    public void delete(int id) {
userRepo.delete(id);
    }

    @Override
    public User find(int id) {
        return userRepo.findOne(id);
    }

    @Override
    public void edit(int id, String firstName, String secondName, String email, String phone, String login, String password,MultipartFile pathToPhoto) {
        User user = userRepo.findOne(id);
        user.setFirstName(firstName);
        user.setSecondName(secondName);
        user.setEmail(email);
        user.setPhone(phone);
        user.setLogin(login);
        user.setPassword(password);

        double random = Math.random()*5000;
        File file = new File("C:\\Users\\Admin\\IdeaProjects\\Blog\\src\\main\\webapp\\resources\\img\\" + random + "." + pathToPhoto.getContentType().split("/")[1]);

        try {
            file.createNewFile();
            pathToPhoto.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();
        }
        user.setPathToPhoto(random + pathToPhoto.getContentType().split("/")[1]);
        userRepo.save(user);
    }

    @Override
    public void activate(String activationKey) {
        User user = userRepo.findByActivationKey(activationKey);
        if(user!=null){
            user.setActive(true);
            user.setActivationKey(null);
        }
        userRepo.save(user);
    }




    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User findByLogin(String login) {
return userRepo.findByLogin(login);
    }



    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user=userRepo.findByLogin(login);
        List<GrantedAuthority> authorities= new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new org.springframework.security.core.userdetails.User(user.getLogin(),user.getPassword(),user.isActive(), true, true, true,authorities);
    }
}
