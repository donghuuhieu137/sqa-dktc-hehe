package com.hieudh.dktc.service;

import com.hieudh.dktc.entity.Subject;

import java.util.List;

public interface SubjectService {
    public List<Subject> findSubjectByCode(String maMon);

    public boolean saveSubject(Long subjectId, Long userId);

    List<Subject> findSubjectByUserId(Long userId);

    Boolean removeSubject(Long subjectId, Long userId);
}
