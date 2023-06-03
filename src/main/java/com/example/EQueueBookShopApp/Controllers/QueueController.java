package com.example.EQueueBookShopApp.Controllers;

import com.example.EQueueBookShopApp.Models.Queue;
import com.example.EQueueBookShopApp.Repositories.QueueRepository;
import com.example.EQueueBookShopApp.Repositories.WindowsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//Класс контроллера очереди
@Controller
public class QueueController {
    @Autowired
    QueueRepository queueRepository;
    @Autowired
    WindowsRepository windowsRepository;

    @GetMapping("/viewEQueue")
    private String EQueueView(Model model) {
        Iterable<Queue> queueWindowIterable = queueRepository.findQueueByStatuses_Name("Вызван");
        model.addAttribute("queueWindow", queueWindowIterable);

        Iterable<Queue> queueIterable = queueRepository.findQueueByStatuses_Name("В ожидании");
        model.addAttribute("queue", queueIterable);
        return "queue/viewEQueue";
    }
}
