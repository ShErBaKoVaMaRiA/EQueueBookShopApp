package com.example.EQueueBookShopApp.Controllers;
import com.example.EQueueBookShopApp.Models.BookShops;
import com.example.EQueueBookShopApp.Models.Events;
import com.example.EQueueBookShopApp.Repositories.BookShopsRepository;
import com.example.EQueueBookShopApp.Repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

@Controller
public class EventsController {
    @Autowired
    EventsRepository eventsRepository;
    @Autowired
    BookShopsRepository bookShopsRepository;

    @GetMapping("/viewEvents")
    public String index(Model model) {
        Iterable<BookShops> bookShopsIterable = bookShopsRepository.findAll();
        model.addAttribute("bookshops", bookShopsIterable);
        Iterable<Events> eventsIterable = eventsRepository.findAll();
        model.addAttribute("events", eventsIterable);

        return "events/viewEvents";
    }
//    @GetMapping("/viewEvents")
//    public String post() {
//        return "events/viewEvents";
//    }
}
