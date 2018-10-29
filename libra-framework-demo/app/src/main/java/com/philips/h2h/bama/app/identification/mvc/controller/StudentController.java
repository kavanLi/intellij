package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Student;
import com.philips.h2h.bama.app.identification.domain.model.StudentModel;
import com.philips.h2h.bama.app.identification.service.atom.StudentService;
import com.philips.h2h.bama.app.identification.service.business.StudentBizService;

/**
 * Created by Ritchie on 9/22/2017.
 */
//REST controller for student services
@RestController
@RequestMapping("/students")
public class StudentController {

    //fields

    @Autowired
    private StudentBizService studentBizService;

    @Autowired
    private StudentService studentService;

    //public methods

    /**
     * show student info
     *
     * @param studentOid target entity oid
     * @return details of entity
     */
    @RequestMapping("/{studentOid}")
    public StudentModel getShow(@PathVariable Long studentOid) {
        StudentModel studentModel = studentBizService.findStudent(studentOid);
        return studentModel;
    }

    /**
     * sign a entity
     *
     * @param model target entity to be store
     * @return oid of student
     */
    @RequestMapping(method = RequestMethod.POST)
    public Long postStore(@RequestBody Student model) {
        StudentModel studentModel = studentBizService.createStudent(model);
        return studentModel.getOid();
    }

    /**
     * update entity info
     *
     * @param studentOid target entity oid to be updated
     * @param model      new entity
     * @return oid of new entity
     */
    @RequestMapping(value = "/{studentOid}", method = RequestMethod.PUT)
    public Long putUpdate(@PathVariable Long studentOid, @RequestBody Student model) {
        model.setOid(studentOid);
        StudentModel studentModel = studentBizService.updateStudent(model);
        return studentModel.getOid();
    }

    /**
     * delete a entity softly
     *
     * @param studentOid target entity oid to be deleted
     */
    @RequestMapping(value = "/{studentOid}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long studentOid) {
        studentService.deleteStudent(studentOid);
    }
}
