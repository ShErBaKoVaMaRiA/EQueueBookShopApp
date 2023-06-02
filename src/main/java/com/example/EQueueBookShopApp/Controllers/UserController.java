package com.example.EQueueBookShopApp.Controllers;

import com.example.EQueueBookShopApp.Models.Roles;
import com.example.EQueueBookShopApp.Models.Users;
import com.example.EQueueBookShopApp.Repositories.RolesRepository;
import com.example.EQueueBookShopApp.Repositories.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Controller
@PreAuthorize("hasAuthority('Клиент')")
public class UserController {

    @Autowired
    RolesRepository rolesRepository;
    @Autowired
    UsersRepository usersRepository;

    @GetMapping("/login")
    private String AuthView()
    {
        return "user/authorization";
    }
    @GetMapping("/registration")
    private String RegView(Users users)
    {
        return "user/registration";
    }

    @PostMapping("/registration")
    public String AddEmployee(@Valid Users users, BindingResult bindingResult,  Model model) {
        if (bindingResult.hasErrors()) {
            return "user/registration";
        }
        usersRepository.addUsers(users.getEmail(),users.getPassword(),5,users.getSurname(),users.getName(),users.getMiddlename(),"Y");
        return "user/authorization";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";


    }

}
