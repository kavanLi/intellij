package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Teacher;
import com.philips.h2h.bama.app.identification.domain.model.TeacherModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
//product business service
@Validated
public interface TeacherBizService {

    /**
     * Save passby entity to store
     *
     * @param model target model to be saved
     * @return saved entity
     */
    TeacherModel createTeacher(@NotNull Teacher model);

    /**
     * Update passby entity model to product entity
     *
     * @param model target model to be saved
     * @return saved entity
     */
    TeacherModel updateTeacher(@NotNull Teacher model);

    /**
     * Load entity according to oid
     *
     * @param teacherOid the oid to find target entity
     * @return existed target entity otherwise null
     */
    TeacherModel findTeacher(@NotNull Long teacherOid);
}
