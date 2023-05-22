package com.example.EQueueBookShopApp.Repositories;


import com.example.EQueueBookShopApp.Models.SignUpEvents;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends CrudRepository<SignUpEvents,Long> {
    public SignUpEvents findSignUpEventsByUID (Long uid);
}
