package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.BookShops;
import com.example.EQueueBookShopApp.Models.Events;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookShopsRepository extends CrudRepository<BookShops,Long> {
    public BookShops findBookShopsByUID (Long uid);
//    BookShops findByNameBookShop (String name);
//    public List<BookShops> findByNameBookShopContains(String name);
}
