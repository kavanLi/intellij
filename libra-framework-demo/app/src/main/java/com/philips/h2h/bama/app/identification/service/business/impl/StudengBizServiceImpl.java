package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Student;
import com.philips.h2h.bama.app.identification.domain.model.StudentModel;
import com.philips.h2h.bama.app.identification.exception.InactiveStudentModificationException;
import com.philips.h2h.bama.app.identification.exception.NotFoundStudentException;
import com.philips.h2h.bama.app.identification.service.atom.StudentService;
import com.philips.h2h.bama.app.identification.service.business.StudentBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//implement sudentBizService interface
@Service
public class StudengBizServiceImpl implements StudentBizService {

    //fields

    private final static Logger logger = LoggerFactory.getLogger(StudengBizServiceImpl.class);

    @Autowired
    private StudentService studentService;

    @Autowired
    private Mapper beanMapper;

    //public methods
    //@see StudentBizService#createStudeng(Student model)
    @Override
    public StudentModel createStudent(@NotNull Student model) {

        //biz logic codes go here.then use atom service to save
        Optional <Student> studentOptional = studentService.saveStudent(model);
        return studentOptional.isPresent() ? beanMapper.map(studentOptional.get(), StudentModel.class) : null;
    }

    //@see StudentBizService#updateStudent(Student model)
    @Override
    public StudentModel updateStudent(@NotNull Student model) {
        Long studentOid = model.getOid();
        Student student;
        Optional <Student> studentOptional = studentService.findStudentById(studentOid);

        if (studentOptional.isPresent()) {
            student = studentOptional.get();
            //case 1:if student is inactive, throw system exception.
            if (!student.getActive()) {
                throw new InactiveStudentModificationException("target student is inactive and can't be modified");
            }
            //biz logic codes go here
            student.setName(model.getName());
            student.setGenderCode(model.getGenderCode());
            student.setStudentId(model.getStudentId());
            studentOptional = studentService.saveStudent(student);
        } else {
            //case 2:if patient cannot be found, throw biz exception
            logger.debug("no patient can be found", studentOid, model);
            throw new NotFoundStudentException("target sudent is not found");
        }
        return studentOptional.isPresent() ? beanMapper.map(studentOptional.get(), StudentModel.class) : null;
    }

    //@see StudentBizService#findStudent(Long studentOid)
    @Override
    public StudentModel findStudent(@NotNull Long studentOid) {
        Optional <Student> studentOptional = studentService.findStudentById(studentOid);
        return studentOptional.isPresent() ? beanMapper.map(studentOptional.get(), StudentModel.class) : null;
    }
}
