package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.BookShops;
import com.example.EQueueBookShopApp.Models.TypesService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypesServiceRepository extends CrudRepository<TypesService,Long> {
    public TypesService findTypesServiceByUID(Long uid);
}
