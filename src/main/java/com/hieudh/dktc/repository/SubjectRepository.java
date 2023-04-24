package com.hieudh.dktc.repository;

import com.hieudh.dktc.entity.Subject;
import com.hieudh.dktc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query(value = "SELECT nextval('item_id_seq')", nativeQuery = true)
    Long getNextSeriesId();

}
