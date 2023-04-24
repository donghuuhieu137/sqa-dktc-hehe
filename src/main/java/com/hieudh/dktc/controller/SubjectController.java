package com.hieudh.dktc.controller;

import com.hieudh.dktc.dto.AjaxDTO;
import com.hieudh.dktc.entity.Subject;
import com.hieudh.dktc.repository.SubjectRepository;
import com.hieudh.dktc.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping(value = "/subject-register", method = RequestMethod.GET)
    public String showHomePage(ModelMap model) {
        return "subject-register";
    }

    @RequestMapping(value = "/subject-register", method = RequestMethod.POST)
    public String getSubject(ModelMap model) {
        return "subject-register";
    }

    @RequestMapping(value = "/subjects", method = RequestMethod.POST)
    public ResponseEntity<AjaxDTO> getSubjectInfo(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response, @RequestBody String maMon) {
        if (maMon != null && maMon.length() > 0 && maMon.charAt(maMon.length() - 1) == '=') {
            maMon = maMon.substring(0, maMon.length() - 1);
        }
        List<Subject> listSubjects = subjectService.findSubjectByCode(maMon);
        System.out.println(listSubjects);
        return ResponseEntity.ok(new AjaxDTO(200, listSubjects));
    }
}
