package com.hieudh.dktc.service.impl;

import com.hieudh.dktc.dto.UserDTO;
import com.hieudh.dktc.entity.Subject;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.repository.UserRepository;
import com.hieudh.dktc.service.SubjectService;
import com.hieudh.dktc.service.UserService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @PersistenceContext protected EntityManager entityManager;
    @Override
    public List<Subject> findSubjectByCode(String maMon) {
        String sql = "SELECT * FROM tbl_mon_hoc AS mh WHERE mh.ma_mon = '"+ maMon + "';" ;
        Query query = entityManager.createNativeQuery(sql, Subject.class);
        return query.getResultList();
    }
}
