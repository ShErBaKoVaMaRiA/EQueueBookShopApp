package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {
    public Users findUsersByUID(Long uid);
    public Users findByEmail(String email);

}

