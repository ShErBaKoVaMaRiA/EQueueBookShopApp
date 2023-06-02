package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Roles;
import com.example.EQueueBookShopApp.Models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesRepository extends CrudRepository<Roles,Long> {

    public Roles findByName(String name);

}