package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Queue;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueueRepository extends CrudRepository<Queue,Long> {
    public Queue findQueueByUID(Long uid);

    public List<Queue> findQueueByStatuses_Name(String name);

//    @Transactional
//    @Modifying
//    @Query(value="UPDATE divisions SET name=?1, address=?2 WHERE uid=?3",nativeQuery=true)
//    void selectQueueWindow(String name,String address, Long uid);
//
//    @Transactional
//    @Modifying
//    @Query(value="UPDATE divisions SET name=?1, address=?2 WHERE uid=?3",nativeQuery=true)
//    void selectQueueWindow(String name,String address, Long uid);
}
