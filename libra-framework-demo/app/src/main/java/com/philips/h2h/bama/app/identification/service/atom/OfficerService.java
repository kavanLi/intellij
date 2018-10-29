package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Officer;

/**
 * Created by Ritchie on 9/22/2017.
 */
// officer service
@Validated
public interface OfficerService {

    /**
     * Save (create/update) passby entity to store
     *
     * @param officer target entity to use.
     * @return saved officer
     */

    Optional <Officer> saveOfficer(@NotNull Officer officer);

    /**
     * find unique entity by id,associates are loaded lazily
     *
     * @param officerOid target oid of entity to use
     * @return target patient existed otherwise null
     */
    Optional <Officer> findOfficerById(@NotNull Long officerOid);

    /**
     * delete entity softly from store
     *
     * @param officerOid delete target-oid entity
     */
    void deleteOfficer(@NotNull Long officerOid);


}
