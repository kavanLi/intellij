package com.philips.h2h.bama.app.identification.service.atom.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.dal.repository.TeacherRepository;
import com.philips.h2h.bama.app.identification.domain.entity.Teacher;
import com.philips.h2h.bama.app.identification.service.atom.TeacherService;

/**
 * Created by Ritchie on 9/22/2017.
 */

/**
 * Implementation class of {@Link TeacherService}
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    // fields
    @Autowired
    private TeacherRepository teacherRepository;

    //public methods

    //@see TeacherService#saveTeacher(Teacher teacher)
    @Override
    public Optional <Teacher> saveTeacher(@NotNull Teacher teacher) {
        return teacherRepository.softlySave(teacher);
    }

    //@see TeacherService#findTeacherById(Java.Lang.Long)
    @Override
    public Optional <Teacher> findTeahcerById(@NotNull Long teacherOid) {
        Teacher teacher = teacherRepository.findOne(teacherOid);
        return Optional.ofNullable(teacher);
    }

    //@see TeacherService#deleteTeacher(Java.Lang.Long)
    @Override
    public void deleteTeacher(@NotNull Long teacherOid) {
        teacherRepository.softlyDelete(teacherOid);
    }
}
