package com.example.EQueueBookShopApp.Controllers;
import com.example.EQueueBookShopApp.Models.BookShops;
import com.example.EQueueBookShopApp.Models.Events;
import com.example.EQueueBookShopApp.Models.SignUpEvents;
import com.example.EQueueBookShopApp.Models.Users;
import com.example.EQueueBookShopApp.Repositories.BookShopsRepository;
import com.example.EQueueBookShopApp.Repositories.EventsRepository;
import com.example.EQueueBookShopApp.Repositories.SignUpRepository;
import com.example.EQueueBookShopApp.Repositories.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
//Класс контроллера регистраций на мероприятия
@Controller
@PreAuthorize("hasAuthority('Клиент')")
public class SignUpController {
    @Autowired
    SignUpRepository signUpRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    BookShopsRepository bookShopsRepository;

    @GetMapping("/myEvents")
    public String index(Model model) {
        Long userID = usersRepository.findByEmail(getCurrentEmail()).getUID();
        Iterable<SignUpEvents> signUpIterable = signUpRepository.findByClient_UID(userID);
        model.addAttribute("signupevents", signUpIterable);
        Iterable<Events> eventsIterable = eventsRepository.findAll();
        model.addAttribute("events", eventsIterable);
        Iterable<BookShops> bookShopsIterable = bookShopsRepository.findAll();
        model.addAttribute("bookshops", bookShopsIterable);
        Iterable<Users> usersIterable = usersRepository.findAll();
        model.addAttribute("client", usersIterable);

        return "events/myEvents";
    }
    public String getCurrentEmail() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }
    @PostMapping("/myEvents/{id}/del")
    @Transactional
    public String deleteSignUp(@PathVariable Long id)
    {
        SignUpEvents sign = signUpRepository.findById(id).orElseThrow();
        signUpRepository.delSignUp(sign.getUID());
        return "redirect:/myEvents";
    }

    @PostMapping("/viewEvents/{id}/signUp")
    @Transactional
    public String addSignUp(@PathVariable Long id)
    {
        Events event = eventsRepository.findById(id).orElseThrow();
        Users user = usersRepository.findByEmail(getCurrentEmail());
        List<SignUpEvents> findsignUp = signUpRepository.findSignUpEventsByClient_UIDAndAndEvents_UID(user.getUID(),event.getUID());
        if(findsignUp.size()==0) {
            signUpRepository.addSignUp(Math.toIntExact(user.getUID()), Math.toIntExact(event.getUID()));
        }
        return "redirect:/viewEvents";
    }
}
