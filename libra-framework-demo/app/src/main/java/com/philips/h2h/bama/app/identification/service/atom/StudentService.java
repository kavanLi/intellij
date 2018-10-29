package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Student;

/**
 * Created by Ritchie on 9/22/2017.
 */
//student service
@Validated
public interface StudentService {

    /**
     * save (create/update) pass-by student entity to store
     *
     * @param student target student entity to use
     * @return saved entity
     */
    Optional <Student> saveStudent(@NotNull Student student);

    /**
     * find unique entity by id,associates are loaded lazily
     *
     * @param studentOid target oid of student entity to use
     * @return target existed student otherwise null
     */
    Optional <Student> findStudentById(@NotNull Long studentOid);

    /**
     * delete entity softly from store
     *
     * @param studentOid delete target-oid entity
     */
    void deleteStudent(@NotNull Long studentOid);
}
