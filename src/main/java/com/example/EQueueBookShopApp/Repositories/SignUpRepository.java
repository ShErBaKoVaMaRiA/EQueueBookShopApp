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
    @Transactional
    @Modifying
    @Query(value="exec SingUpEvent_Delete @ID_SignUpEvent=:uid;",nativeQuery=true)
    void delSignUp(@Param("uid")Long uid);

}
