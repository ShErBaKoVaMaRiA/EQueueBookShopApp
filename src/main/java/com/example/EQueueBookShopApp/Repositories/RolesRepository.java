package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Roles;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Класс репозитория ролей
@Repository
public interface RolesRepository extends CrudRepository<Roles,Long> {
    public Roles findByName(String name);

}