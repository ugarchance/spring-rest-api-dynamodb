package com.ugar.databasecrud.repository;

import com.ugar.databasecrud.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    User findByUsername(String username);
}
