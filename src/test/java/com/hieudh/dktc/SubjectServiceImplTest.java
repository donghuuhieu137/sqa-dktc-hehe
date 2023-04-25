package com.hieudh.dktc;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.hieudh.dktc.service.impl.SubjectServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.hieudh.dktc.entity.Subject;
import com.hieudh.dktc.repository.SubjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceImplTest {

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;

    @Mock
    private SubjectRepository subjectRepository;

    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        when(entityManager.createNativeQuery(anyString(), eq(Subject.class))).thenReturn(query);
    }

    @Test
    public void testFindSubjectByCode() {
        String maMon = "ABC";
        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(new Subject(1,"ABC", "Test Subject", 3, 0, 3, 3, "ABC", 30, 2));
        when(query.getResultList()).thenReturn(expectedSubjects);

        List<Subject> actualSubjects = subjectService.findSubjectByCode(maMon);

        assertEquals(expectedSubjects, actualSubjects);
    }

    @Test
    public void testSaveSubject() {
        Long subjectId = 1L;
        Long userId = 2L;
        Subject subject = new Subject(1,"ABC123", "Subject 1",3, 0, 3, 3, "ABC", 30, 2);
        subject.setConLai(1);
        Query queryCheck = mock(Query.class);
        when(entityManager.createNativeQuery(any(String.class), any(Class.class))).thenReturn(queryCheck);
        when(queryCheck.getResultList()).thenReturn(List.of(subject));
        Query queryUpdate = mock(Query.class);
        when(entityManager.createNativeQuery(any(String.class))).thenReturn(queryUpdate);
        Query query = mock(Query.class);
        when(entityManager.createNativeQuery(any(String.class))).thenReturn(query);
        int expectedConLai = subject.getConLai() - 1;
        when(query.executeUpdate()).thenReturn(1);
        boolean result = subjectService.saveSubject(subjectId, userId);
        assertNotEquals(expectedConLai, subject.getConLai());
        assertEquals(true, result);
    }

    @Test
    public void testFindSubjectByUserId() {
        // Arrange
        Long userId = 1L;
        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(new Subject(1, "ABC123", "Subject 1", 3, 0, 3, 3, "ABC", 30, 2));
        expectedSubjects.add(new Subject(2, "DEF456", "Subject 2",3, 0, 3, 3, "ABC", 30, 2));
        String sql = "SELECT mh.* FROM tbl_mon_hoc AS mh INNER JOIN users_subjects AS us ON mh.id = us.subject_id WHERE us.user_id = "+ userId +"";
//        when(entityManager.createNativeQuery(sql,Subject.class)).thenReturn(expectedSubjects);

        // Act
        List<Subject> actualSubjects = subjectService.findSubjectByUserId(userId);

        // Assert
        assertEquals(expectedSubjects.size(), actualSubjects.size());
        assertEquals(expectedSubjects.get(0).getTen(), actualSubjects.get(0).getTen());
        assertEquals(expectedSubjects.get(1).getTen(), actualSubjects.get(1).getTen());
    }
}
