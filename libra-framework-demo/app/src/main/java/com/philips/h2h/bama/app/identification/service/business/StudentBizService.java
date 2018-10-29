package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Student;
import com.philips.h2h.bama.app.identification.domain.model.StudentModel;

/**
 * Created by Ritchie on 9/22/2017.
 */
//product business service
@Validated
public interface StudentBizService {
    /**
     * Save passby entity to store
     *
     * @param model target model to be saved
     * @return saved entity
     */
    StudentModel createStudent(@NotNull Student model);

    /**
     * Update passby entity model to product entity
     *
     * @param model target model to be saved
     * @return saved entity
     */
    StudentModel updateStudent(@NotNull Student model);

    /**
     * load entity according to oid
     *
     * @param studentOid the oid to find target model
     * @return existed target entity otherwise null
     */
    StudentModel findStudent(@NotNull Long studentOid);
}
