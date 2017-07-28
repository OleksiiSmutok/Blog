package com.oleksii.home.controllers;

import com.oleksii.home.entity.Article;
import com.oleksii.home.entity.Comments;
import com.oleksii.home.entity.User;
import com.oleksii.home.service.ArticleService;
import com.oleksii.home.service.CommentsService;
import com.oleksii.home.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Admin on 28.04.2017.
 */
@Controller
public class BaseController {

    @Autowired
    ArticleService articleService;

    @Autowired
    UserService userService;

    @Autowired
    CommentsService commentsService;

    @Qualifier("userValidator")
    @Autowired
    private Validator validator;

    @RequestMapping(value = "/read/article/{id}",method = RequestMethod.GET)
    public String reedArticle(@PathVariable Integer id,Model model,Principal principal){
        User user = userService.findByLogin(principal.getName());
        Article article = articleService.findOne(id);
        List<Comments>comments = commentsService.findCommentsByArticle(article);
        model.addAttribute("comments",comments);
        model.addAttribute("article",article);
        model.addAttribute("user",user);
        return "readArticle";
    }
    @RequestMapping(value = "/view/article",method = RequestMethod.GET)
    public String viewArticle(Model model,Principal principal){
        User user = userService.findByLogin(principal.getName());
        List<Article> articleList = articleService.findAll();
        Collections.reverse(articleList);
        model.addAttribute("articleList",articleList);
        model.addAttribute("user",user);
     return "viewArticle";
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
      public  String home(Model model,Principal principal){
        User user = userService.findByLogin(principal.getName());
        List<Article> articleList = articleService.findAll();
        Collections.reverse(articleList);
        model.addAttribute("articleList",articleList);
        model.addAttribute("user",user);
          return "home";
      }

    @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
    public String login(){
        return "loginPage";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @RequestMapping(value = "/processing/registration",method = RequestMethod.POST)
    public String processingRegistration(@ModelAttribute User user,BindingResult bindingResult){
        validator.validate(user,bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }else {
            userService.add(user);
            return "redirect:/loginPage";
        }
    }

    @RequestMapping(value = "/activate/{activationKey}", method = RequestMethod.GET)
    public String activate(@PathVariable String activationKey){
        userService.activate(activationKey);
        return "redirect:/";
    }

    @RequestMapping(value = "/avatar/page",method = RequestMethod.GET)
    public String avatarPage(){
        return "avatar";
    }

    @RequestMapping(value = "/add/avatar",method = RequestMethod.POST)
    public String addAvatar(Principal principal,
                            @RequestParam("photo")MultipartFile pathToPhoto){
        User user = userService.findByLogin(principal.getName());
        userService.addPhoto(user,pathToPhoto);
        return "redirect:/";
    }

    @RequestMapping(value = "/add/article",method = RequestMethod.POST)
    public String addArticle(Principal principal,
                             @RequestParam("subject")String subject,
                             @RequestParam("text")String text,
                             @RequestParam("photo")MultipartFile multipartFile) {

        User user = userService.findByLogin(principal.getName());
        java.util.Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTime().getTime());
        articleService.add(subject,text,date,multipartFile,user);
        return "redirect:/";
    }
    @RequestMapping(value = "/add/comment/{id}",method = RequestMethod.POST)
    public String addComment(@PathVariable Integer id,Principal principal,
                             @RequestParam("text")String text,
                             @RequestParam("mark")String mark){
        User user = userService.findByLogin(principal.getName());
        Article article = articleService.findOne(id);
        java.util.Calendar calendar = Calendar.getInstance();
        Date date = new Date(calendar.getTime().getTime());
        commentsService.add(text,mark,date,user,article);
        return "redirect:/";
    }
    @RequestMapping(value = "/edit/article/{id}",method = RequestMethod.GET)
    public String editArticle(@PathVariable Integer id,Model model,Principal principal){
        User user = userService.findByLogin(principal.getName());
        Article article = articleService.findOne(id);
        model.addAttribute("user",user);
        model.addAttribute(article);
        return "editArticle";
    }
    @RequestMapping(value = "/edit/article/processing/{id}",method = RequestMethod.POST)
    public String editArticleProcessing(@PathVariable Integer id,Principal principal,
                                        @RequestParam("subject")String subject,
                                        @RequestParam("text")String text,
                                        @RequestParam("photo")MultipartFile photo){
        User user = userService.findByLogin(principal.getName());
        Article article = articleService.findOne(id);
        if(user.getId()==article.getUser().getId()){
            articleService.edit(id,subject,text,photo);
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/edit/user/page/{id}",method = RequestMethod.GET)
    public String editUser(@PathVariable Integer id, Model model,Principal principal){
        User user = userService.findByLogin(principal.getName());
        model.addAttribute("user",user);
        return "editUser";
    }
    @RequestMapping(value = "/edit/user/{id}",method = RequestMethod.POST)
    public String editUser(@PathVariable Integer id,Principal principal,
                           @RequestParam("firstName")String firstName,
                           @RequestParam("secondName")String secondName,
                           @RequestParam("email")String email,
                           @RequestParam("phone")String phone,
                           @RequestParam("login")String login,
                           @RequestParam("password")String password,
                           @RequestParam("pathToPhoto")MultipartFile pathToPhoto){
        User users = userService.findByLogin(principal.getName());
            userService.edit(id,firstName,secondName,email,phone,login,password,pathToPhoto);
            return "redirect:/";
        }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable Integer id,Principal principal){
        User user = userService.findByLogin(principal.getName());
        Article article = articleService.findOne(id);
        if(user.getId()==article.getUser().getId()) {
            articleService.delete(id);
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/delete/comment/{id}",method = RequestMethod.GET)
    public String deleteComment(@PathVariable Integer id,Principal principal){
        User user = userService.findByLogin(principal.getName());
        Comments comments = commentsService.findOne(id);
        Article article = comments.getArticle();
        if(user.getId()==comments.getUser().getId()){
            commentsService.delete(id);
        }
        return "redirect:/";
    }

}
