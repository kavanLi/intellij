package com.philips.h2h.bama.app.identification.service.business.impl;

import java.util.Optional;

import javax.validation.constraints.NotNull;


import org.dozer.Mapper;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.philips.h2h.bama.app.identification.domain.entity.Teacher;
import com.philips.h2h.bama.app.identification.domain.model.StudentModel;
import com.philips.h2h.bama.app.identification.domain.model.TeacherModel;
import com.philips.h2h.bama.app.identification.exception.InactiveTeacherModificationException;
import com.philips.h2h.bama.app.identification.service.atom.TeacherService;
import com.philips.h2h.bama.app.identification.service.business.TeacherBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
// implement teacherBizService interface
@Service
public class TeacherBizServiceImpl implements TeacherBizService {
    //fields

    private final static Logger logger = LoggerFactory.getLogger(TeacherBizService.class);

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private Mapper beenMapper;

    //public methods

    //@see TeacherBizService#createTeacher(Teacher model)
    @Override
    public TeacherModel createTeacher(@NotNull Teacher model) {
        //biz logic codes go here, then use atom service to save it.
        Optional <Teacher> teacherOptional = teacherService.saveTeacher(model);
        return teacherOptional.isPresent() ? beenMapper.map(teacherOptional.get(), TeacherModel.class) : null;
    }

    //@see TeacherBizService#updateTeacher(Teacher model)
    @Override
    public TeacherModel updateTeacher(@NotNull Teacher model) {
        Long teacherOid = model.getOid();
        Teacher teacher;
        Optional <Teacher> teacherOptional = teacherService.findTeahcerById(teacherOid);
        if (teacherOptional.isPresent()) {
            teacher = teacherOptional.get();
            //case 1:if target teacher inactive, throw a system exception
            if (!teacher.getActive()) {
                throw new InactiveTeacherModificationException("inactive teacher, cannot be modified");
            }

            //biz logical go here
            teacher.setName(model.getName());
            teacher.setGenderCode(model.getGenderCode());
            teacher.setTeacherId(model.getInteacherId());
            teacherOptional = teacherService.saveTeacher(teacher);
        } else {
            //case 2:if entity cannot be found,throw a biz exception
            logger.debug("entity is not exist", teacherOid, model);
        }
        return teacherOptional.isPresent() ? beenMapper.map(teacherOptional.get(), TeacherModel.class) : null;
    }

    //@see TeacherBizService#findTeacher(Long teacherOid)
    @Override
    public TeacherModel findTeacher(@NotNull Long teacherOid) {
        Optional <Teacher> teacherOptional = teacherService.findTeahcerById(teacherOid);
        return teacherOptional.isPresent() ? beenMapper.map(teacherOptional.get(), TeacherModel.class) : null;
    }
}
