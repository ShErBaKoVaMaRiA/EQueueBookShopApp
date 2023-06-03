package com.example.EQueueBookShopApp.Repositories;
import com.example.EQueueBookShopApp.Models.BookShops;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//Класс репозитория книжных магазинов
@Repository
public interface BookShopsRepository extends CrudRepository<BookShops,Long> {
    public BookShops findBookShopsByUID (Long uid);
}
