package com.philips.h2h.bama.app.identification.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.philips.h2h.bama.app.identification.domain.entity.Teacher;
import com.philips.h2h.bama.app.identification.domain.model.TeacherModel;
import com.philips.h2h.bama.app.identification.service.atom.TeacherService;
import com.philips.h2h.bama.app.identification.service.business.TeacherBizService;

/**
 * Created by Ritchie on 9/23/2017.
 */
//REST controller for teacher service
@RestController
@RequestMapping("/teachers")
public class TeacherController {

    //fields

    @Autowired
    private TeacherBizService teacherBizService;

    @Autowired
    private TeacherService teacherService;

    //public methods

    /**
     * get teacher info
     *
     * @param teacherOid target teacher oid
     * @return details of teacher
     */
    @RequestMapping(value = "/{teacherOid}")
    public TeacherModel getShow(@PathVariable Long teacherOid) {
        TeacherModel teacherModel = teacherBizService.findTeacher(teacherOid);
        return teacherModel;
    }

    /**
     * store a teacher
     *
     * @param model info of teacher
     * @return teacher number
     */
    @RequestMapping(method = RequestMethod.POST)
    public Long postStore(@RequestBody Teacher model) {
        TeacherModel teacherModel = teacherBizService.createTeacher(model);
        return teacherModel.getOid();
    }

    /**
     * update teacher info
     *
     * @param teacherOid target oid to be renew
     * @param model      detail info of teacher
     * @return updated teacher oid
     */
    @RequestMapping(value = "/{teacherOid}", method = RequestMethod.PUT)
    public Long putUpdate(@PathVariable Long teacherOid, @RequestBody Teacher model) {
        model.setOid(teacherOid);
        TeacherModel teacherModel = teacherBizService.updateTeacher(model);
        return teacherModel.getOid();
    }

    /**
     * delete teacher info softly
     *
     * @param teacherOid target teacher oid
     */
    @RequestMapping(value = "/{teacherOid}", method = RequestMethod.DELETE)
    public void deleteTeacher(@PathVariable Long teacherOid) {
        teacherService.deleteTeacher(teacherOid);
    }
}
