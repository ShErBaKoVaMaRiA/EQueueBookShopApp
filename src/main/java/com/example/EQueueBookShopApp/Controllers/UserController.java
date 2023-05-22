package com.example.EQueueBookShopApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/authorization")
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
    private String MyProfileView()
    {
        return "user/myProfile";
    }
}
