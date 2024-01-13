package com.ugar.databasecrud.repository;

import com.ugar.databasecrud.entity.Location;
import com.ugar.databasecrud.entity.User;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableScan
public interface LocationRepository extends CrudRepository<Location,String> {
    Location findByTimestamp(String timestamp);
    // Belirli bir zaman aralığı için sorgu yapacak metot
    User finByUser(String user);

}
