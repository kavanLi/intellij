package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Teacher;

/**
 * Created by Ritchie on 9/22/2017.
 */
//tercher service
@Validated
public interface TeacherService {

    /**
     * Save (create/update) passby teacher entity to store
     *
     * @param teacher target teacher entity to use.
     * @return saved entity
     */
    Optional <Teacher> saveTeacher(@NotNull Teacher teacher);

    /**
     * find unique entity by id,associates are loaded lazily
     *
     * @param teacherOid target oid of entity to use
     * @return target existed teacher otherwise null
     */
    Optional <Teacher> findTeahcerById(@NotNull Long teacherOid);

    /**
     * delete entity softly from store
     *
     * @param teacherOid delete target-oid entity
     */
    void deleteTeacher(@NotNull Long teacherOid);
}
