package com.coderhouse.repository;


import com.coderhouse.model.database.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<User, String> {

}
