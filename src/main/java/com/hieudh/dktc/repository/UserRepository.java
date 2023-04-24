package com.hieudh.dktc.repository;

import com.hieudh.dktc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT nextval('item_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

    public User findOneByUsername(String username);

}
