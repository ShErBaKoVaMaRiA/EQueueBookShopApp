package com.example.EQueueBookShopApp.Controllers;

import com.example.EQueueBookShopApp.Models.Users;
import com.example.EQueueBookShopApp.Repositories.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
@PreAuthorize("hasAuthority('Клиент')")
public class UserController {
    @Autowired
    UsersRepository usersRepository;
    @GetMapping("/login")
    private String AuthView()
    {
        return "user/authorization";
    }
    @GetMapping("/registration")
    private String RegView()
    {
        return "user/registration";
    }
    @GetMapping("/myProfile")
    private String MyProfileView(Model model){
        Users user_obj = usersRepository.findByEmail(getCurrentEmail());
        model.addAttribute("one_user", user_obj);
        return "user/myProfile";
    }
    public String getCurrentEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return auth.getName();
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
