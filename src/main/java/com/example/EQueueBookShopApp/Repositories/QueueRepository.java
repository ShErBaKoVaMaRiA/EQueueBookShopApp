package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Queue;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//Класс репозитория очереди
@Repository
public interface QueueRepository extends CrudRepository<Queue,Long> {
    public Queue findQueueByUID(Long uid);
    public List<Queue> findQueueByStatuses_Name(String name);
}
