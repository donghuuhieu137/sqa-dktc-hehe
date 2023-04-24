package com.hieudh.dktc.service.impl;

import com.hieudh.dktc.dto.UserDTO;
import com.hieudh.dktc.entity.Subject;
import com.hieudh.dktc.entity.TimeTable;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.repository.SubjectRepository;
import com.hieudh.dktc.repository.UserRepository;
import com.hieudh.dktc.service.SubjectService;
import com.hieudh.dktc.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {
    @PersistenceContext
    protected EntityManager entityManager;

    @Autowired
    SubjectRepository subjectRepository;

    @Override
    public List<Subject> findSubjectByCode(String maMon) {
        String sql = "SELECT * FROM tbl_mon_hoc AS mh WHERE mh.ma_mon = '" + maMon + "';";
        Query query = entityManager.createNativeQuery(sql, Subject.class);
        List<Subject> listSubject = (List<Subject>) query.getResultList();
        return listSubject;
    }

    @Override
    public boolean saveSubject(Long subjectId, Long userId) {
        //Update Safe Rule DBMS
        String sqlUpdateRule = "SET SQL_SAFE_UPDATES = 0;";
        Query queryUpdate = entityManager.createNativeQuery(sqlUpdateRule);
        queryUpdate.executeUpdate();
        // Kiem tra so luong con lai cua mon
        String sqlKiemTraCL = "SELECT * FROM tbl_mon_hoc WHERE id = " + subjectId + ";";
        Query queryCheck = entityManager.createNativeQuery(sqlKiemTraCL, Subject.class);
        Subject subject = (Subject) queryCheck.getResultList().get(0);
        int conLai = subject.getConLai();
        if (conLai <= 0) {
            return false;
        }
        // Giam so luong con lai cua mon
        String sqlGiamCL = "UPDATE tbl_mon_hoc SET con_lai = CASE WHEN con_lai > 0 THEN con_lai - 1 ELSE 0 END WHERE id = " + subjectId + ";";
        Query query = entityManager.createNativeQuery(sqlGiamCL);
        query.executeUpdate();
        // Luu mon hoc da dang ky cho nguoi dung
        String sqlSaveUserSubject = "INSERT INTO users_subjects (`user_id`, `subject_id`) VALUES ('" + userId + "', '" + subjectId + "');";
        Query querySave = entityManager.createNativeQuery(sqlSaveUserSubject);
        querySave.executeUpdate();
        return true;
    }
}
