package com.philips.h2h.bama.app.identification.dal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;

import com.philips.h2h.bama.app.identification.domain.entity.Doctor;
import com.philips.h2h.bama.platform.core.dal.repository.BaseRepository;

/**
 * Created by Ritchie on 9/19/2017.
 */

/**
 * Doctor repository.
 */
public interface DoctorRepository extends BaseRepository <Doctor, Long> {
}
