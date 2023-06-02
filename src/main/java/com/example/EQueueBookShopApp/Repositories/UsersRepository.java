package com.example.EQueueBookShopApp.Repositories;

import com.example.EQueueBookShopApp.Models.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users,Long> {
    public Users findUsersByUID(Long uid);

    public Users findByEmail(String email);
    @Modifying
    @Query(value="exec User_Insert @EmailUser= ?,@PasswordUser= ?,@Role_ID=?,@SurnameUser= ?,@NameUser= ?,@MiddleNameUser= ?,@ConsentPersonalData= ?;",nativeQuery=true)
    void addUsers(String email,String password,Integer role,String surname,String name,String middlename,String personal);
    @Modifying
    @Query(value="exec User_Update @ID_User = ?,@EmailUser= ?,@PasswordUser= ?,@Role_ID=?,@SurnameUser= ?,@NameUser= ?,@MiddleNameUser= ?,@ConsentPersonalData= ?;",nativeQuery=true)
    @Transactional
    void editUsers(Long id,String email,String password,Integer role,String surname,String name,String middlename,String personal);


}

