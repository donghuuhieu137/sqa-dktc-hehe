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
import java.time.Instant;
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

    @Autowired
    UserService userService;

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
        // Kiem tra trong thoi gian dang ki
        long startTime = 1682294400000L; // Monday, 24 April 2023 00:00:00
        long endTime = 1685577600000L; // Thursday, 1 June 2023 00:00:00
        long now = Instant.now().toEpochMilli();
        if(!(now > startTime && now < endTime)){
            return false;
        }
        // Kiem tra so luong con lai cua mon
        String sqlKiemTraCL = "SELECT * FROM tbl_mon_hoc WHERE id = " + subjectId + ";";
        Query queryCheck = entityManager.createNativeQuery(sqlKiemTraCL, Subject.class);
        Subject subject = (Subject) queryCheck.getResultList().get(0);
        int conLai = subject.getConLai();
        if (conLai <= 0) {
            return false;
        }
        // Kiem tra gioi han tin chi
        if (!(subject.getSoTinChi() > 0 && subject.getSoTinChi() < 20)){
            return false;
        }
        // Kiem tra khoa cua nguoi dung hop le
        User user = userService.findById(userId);
        if(user.getKhoa() > subject.getKhoaToiThieu()){
            return false;
        }
        // Kiem tra thoi gian hoc bi trung
        String sqlKiemTraTrungLich = "SELECT * FROM tbl_timetable WHERE subject_id = "+ subjectId +";";
        Query queryKiemTraTrungLich = entityManager.createNativeQuery(sqlKiemTraTrungLich, TimeTable.class);
        List<TimeTable> listTimetableSubject = (List<TimeTable>) queryKiemTraTrungLich.getResultList();
        String sqlKiemTraTrungLichNguoiDung = "SELECT tt.* FROM tbl_timetable AS tt INNER JOIN users_subjects AS us ON us.subject_id = tt.subject_id INNER JOIN tbl_user AS u ON u.id = us.user_id WHERE u.id = " + userId +";";
        Query queryKiemTraTrungLichNguoiDung = entityManager.createNativeQuery(sqlKiemTraTrungLichNguoiDung, TimeTable.class);
        List<TimeTable> listTimetableUserSubject = (List<TimeTable>) queryKiemTraTrungLichNguoiDung.getResultList();
        for (TimeTable userTimetable: listTimetableUserSubject){
            String userThu = userTimetable.getThu();
            String userTuan = userTimetable.getTuan();
            for (TimeTable subjectTimetable: listTimetableSubject){
                String subjectThu = subjectTimetable.getThu();
                String subjectTuan = subjectTimetable.getTuan();
                if(userThu.equals(subjectThu)) {
                    for (int i=0; i<userTuan.length(); i++){
                        char userTuanChar = userTuan.charAt(i);
                        char subjectTuanChar = subjectTuan.charAt(i);
                        if(userTuanChar == subjectTuanChar){
                            System.out.println("Thoi gian hoc bi trung");
                            return false;
                        }
                    }
                }
            }
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

    @Override
    public List<Subject> findSubjectByUserId(Long userId) {
        String sql = "SELECT mh.* FROM tbl_mon_hoc AS mh INNER JOIN users_subjects AS us ON mh.id = us.subject_id WHERE us.user_id = "+ userId +"";
        Query query = entityManager.createNativeQuery(sql,Subject.class);
        List<Subject> subjects =  query.getResultList();
        return subjects;
    }

    @Override
    public Boolean removeSubject(Long subjectId, Long userId) {
        //Update Safe Rule DBMS
        String sqlUpdateRule = "SET SQL_SAFE_UPDATES = 0;";
        Query queryUpdate = entityManager.createNativeQuery(sqlUpdateRule);
        queryUpdate.executeUpdate();
        // Tang so luong con lai cua mon
        String sqlGiamCL = "UPDATE tbl_mon_hoc SET con_lai = CASE WHEN con_lai > 0 THEN con_lai + 1 ELSE 0 END WHERE id = " + subjectId + ";";
        Query query = entityManager.createNativeQuery(sqlGiamCL);
        query.executeUpdate();
        // Xoa mon hoc da dang ky cho nguoi dung
        String sqlRemoveUserSubject = "DELETE FROM users_subjects AS us WHERE us.user_id = '" + userId + "' AND us.subject_id = '" + subjectId + "';";
        System.out.println(sqlRemoveUserSubject);
        Query queryRemove = entityManager.createNativeQuery(sqlRemoveUserSubject);
        queryRemove.executeUpdate();
        return true;
    }
}
