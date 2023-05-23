package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {
    public Users findUsersByUID(Long uid);
    public List<Users> findUsersByEmail(String Email);
}

