package com.example.EQueueBookShopApp.Repositories;


import com.example.EQueueBookShopApp.Models.SignUpEvents;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignUpRepository extends CrudRepository<SignUpEvents,Long> {
    public SignUpEvents findSignUpEventsByUID (Long uid);
    Iterable<SignUpEvents> findByClient_UID (Long uid);
    @Modifying
    @Query(value="delete from [dbo].[Table_SignUpEvents] where [ID_SignUpEvent]= ? ;",nativeQuery=true)
    void delSignUp(Integer uid);

    @Modifying
    @Query(value="exec SingUpEvent_Insert @Client_ID= ? ,@Event_ID= ? ;",nativeQuery=true)
    void addSignUp(Integer client, Integer event);

//    SELECT count(ID_SignUpEvent) as columnCount FROM Table_SignUpEvents WHERE Client_ID =  12 and Event_ID = 1 ;
    public List<SignUpEvents> findSignUpEventsByClient_UIDAndAndEvents_UID (Long client, Long event);

}
