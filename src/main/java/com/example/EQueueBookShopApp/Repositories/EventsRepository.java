package com.example.EQueueBookShopApp.Repositories;
import com.example.EQueueBookShopApp.Models.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Класс репозитория мероприятий
@Repository
public interface EventsRepository extends CrudRepository<Events,Long>{
    public Events findEventsByUID (Long uid);
}
