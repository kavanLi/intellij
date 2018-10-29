package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Guard;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface GuardService {

    Optional <Guard> saveGuard(@NotNull Guard guard);

    Optional <Guard> findGuardById(@NotNull Long guardOid);

    void deleteGuardByID(@NotNull Long guardOid);
}
