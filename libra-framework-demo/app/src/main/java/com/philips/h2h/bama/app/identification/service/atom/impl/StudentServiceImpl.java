package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.StudentRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Student;
import com.philips.h2h.bama.app.identification.service.atom.StudentService;

/**
 * Created by Ritchie on 9/22/2017.
 */

/**
 * Implementation class of {@Link StudentService}
 */
@Service
public class StudentServiceImpl implements StudentService {

    //fields
    @Autowired
    private StudentRepository studentRepository;

    //public methods

    //@see StudentService#saveStudent(Student student)
    @Override
    public Optional <Student> saveStudent(@NotNull Student student) {
        return studentRepository.softlySave(student);
    }

    //@see StudentService#findStudentById(Java.Lang.Long)
    @Override
    public Optional <Student> findStudentById(@NotNull Long studentOid) {
        Student student = studentRepository.findOne(studentOid);
        return Optional.ofNullable(student);
    }

    //@see StudentService#deleteStudent(Java.Lang.Long)
    @Override
    public void deleteStudent(@NotNull Long studentOid) {
        studentRepository.softlyDelete(studentOid);
    }
}
