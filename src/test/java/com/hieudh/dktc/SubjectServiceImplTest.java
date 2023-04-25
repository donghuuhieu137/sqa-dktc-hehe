package com.hieudh.dktc;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.*;

import javax.persistence.*;

import com.hieudh.dktc.entity.TimeTable;
import com.hieudh.dktc.entity.User;
import com.hieudh.dktc.service.impl.SubjectServiceImpl;
import com.hieudh.dktc.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import com.hieudh.dktc.entity.Subject;
import java.util.Optional;
import com.hieudh.dktc.repository.SubjectRepository;

@RunWith(MockitoJUnitRunner.class)
public class SubjectServiceImplTest {
    @Mock
    private UserServiceImpl userService;

    @Mock
    private SubjectRepository subjectRepository;


    @InjectMocks
    private SubjectServiceImpl subjectService;

    @Mock
    private EntityManager entityManager;

    @Mock
    private Query query;


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

        // Mocking the database queries
        Subject subject = new Subject();
        subject.setId(Math.toIntExact(subjectId));
        subject.setConLai(1);
        subject.setKhoaToiThieu(3);
        subject.setSoTinChi(3);
        Query query = mock(Query.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);
//        Long userId = 1L;
        User user = new User();
        user.setId(1L);

        when(userService.findById(1L)).thenReturn(user);
        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(new Subject(1,"ABC", "Test Subject", 3, 0, 3, 3, "ABC", 30, 2));
        when(query.getResultList()).thenReturn(expectedSubjects);


        // Testing the function call
        boolean result = subjectService.saveSubject(subjectId, userId);
        assertTrue(result);
    }

    @Test
    public void testFindSubjectByUserId() {
        // Arrange
        Long userId = 1L;
        List<Subject> expectedSubjects = new ArrayList<>();
        expectedSubjects.add(new Subject(1, "ABC123", "Subject 1", 3, 0, 3, 3, "ABC", 30, 2));
        expectedSubjects.add(new Subject(2, "DEF456", "Subject 2",3, 0, 3, 3, "ABC", 30, 2));
//        String sql = "SELECT mh.* FROM tbl_mon_hoc AS mh INNER JOIN users_subjects AS us ON mh.id = us.subject_id WHERE us.user_id = "+ userId +"";
        when(query.getResultList()).thenReturn(expectedSubjects);

        // Act
        List<Subject> actualSubjects = subjectService.findSubjectByUserId(userId);

        // Assert
        assertEquals(expectedSubjects.size(), actualSubjects.size());
        assertEquals(expectedSubjects.get(0).getTen(), actualSubjects.get(0).getTen());
        assertEquals(expectedSubjects.get(1).getTen(), actualSubjects.get(1).getTen());
    }

    @Test
    public void testRemoveSubject() {
        // arrange
        Long subjectId = 1L;
        Long userId = 2L;
        Query query = mock(Query.class);
        when(entityManager.createNativeQuery(anyString())).thenReturn(query);

        // act
        boolean actualResult = subjectService.removeSubject(subjectId, userId);

        // assert
//        verify(entityManager, times(2)).createNativeQuery(anyString());
//        verify(query, times(2)).executeUpdate();
        Assert.assertTrue(actualResult);
    }


}
