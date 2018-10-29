package com.philips.h2h.bama.app.identification.service.atom;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Plumber;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PlumberService {

    Optional <Plumber> savePlumber(@NotNull Plumber plumber);

    Optional <Plumber> findPlumberById(@NotNull Long plumberOid);

    void deletePlumberByID(@NotNull Long plumberOid);
}
