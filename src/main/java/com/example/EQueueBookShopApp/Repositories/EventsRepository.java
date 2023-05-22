package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EventsRepository extends CrudRepository<Events,Long>{
    public Events findEventsByUID (Long uid);
//    public List<Events> findByNameEventContains(String name);
}
