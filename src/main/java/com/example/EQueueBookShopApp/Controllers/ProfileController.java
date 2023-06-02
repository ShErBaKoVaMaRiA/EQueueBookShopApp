package com.example.EQueueBookShopApp.Controllers;

import com.example.EQueueBookShopApp.Models.Roles;
import com.example.EQueueBookShopApp.Models.Users;
import com.example.EQueueBookShopApp.Repositories.RolesRepository;
import com.example.EQueueBookShopApp.Repositories.UsersRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProfileController {
    @Autowired
    UsersRepository usersRepository;
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
}
