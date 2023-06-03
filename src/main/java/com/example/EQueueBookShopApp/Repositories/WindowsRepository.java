package com.example.EQueueBookShopApp.Repositories;
import com.example.EQueueBookShopApp.Models.Windows;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Класс репозитория окон обслуживания
@Repository
public interface WindowsRepository extends CrudRepository<Windows,Long> {
    public Windows findWindowsByUID(Long uid);
}