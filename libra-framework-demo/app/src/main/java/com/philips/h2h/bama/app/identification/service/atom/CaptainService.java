package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Captain;

/**
 * Created by Ritchie on 9/24/2017.
 */
@Validated
public interface CaptainService {

    Optional <Captain> saveCaptain(@NotNull Captain captain);

    Optional <Captain> findCaptainById(@NotNull Long captainOid);

    void deleteCaptainById(@NotNull Long captainOid);
}
