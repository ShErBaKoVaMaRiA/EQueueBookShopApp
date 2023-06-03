package com.example.EQueueBookShopApp.Controllers;

import com.example.EQueueBookShopApp.Models.Users;
import com.example.EQueueBookShopApp.Repositories.RolesRepository;
import com.example.EQueueBookShopApp.Repositories.UsersRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
//Класс контроллера пользователя
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
    public String getCurrentEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @GetMapping("/myProfile")
    private String MyProfileView(Model model){
        Users user_obj = usersRepository.findByEmail(getCurrentEmail());
        model.addAttribute("users",user_obj);
        return "user/myProfile";
    }
    @PostMapping("/myProfile")
    private String MyProfileEdit(@Valid Users users, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()) {
            return "user/myProfile";
        }
        usersRepository.editUsers(usersRepository.findByEmail(getCurrentEmail()).getUID(),users.getEmail(),users.getPassword(),5,users.getSurname(),users.getName(),users.getMiddlename(),"Y");
        return "redirect:/myProfile";
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
