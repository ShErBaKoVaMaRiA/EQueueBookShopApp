package com.example.EQueueBookShopApp.Repositories;


import com.example.EQueueBookShopApp.Models.SignUpEvents;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SignUpRepository extends CrudRepository<SignUpEvents,Long> {
    public SignUpEvents findSignUpEventsByUID (Long uid);
    Iterable<SignUpEvents> findByClient_UID (Long uid);
    @Modifying
    @Query(value="delete from [dbo].[Table_SignUpEvents] where [ID_SignUpEvent]= ? ;",nativeQuery=true)
    void delSignUp(Integer uid);

}
