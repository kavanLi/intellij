package com.philips.h2h.bama.app.identification.service.business;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import com.philips.h2h.bama.app.identification.domain.entity.Plumber;
import com.philips.h2h.bama.app.identification.domain.model.PlumberModel;

/**
 * Created by Ritchie on 9/23/2017.
 */
@Validated
public interface PlumberBizService {

    PlumberModel createPlumber(@NotNull Plumber model);

    PlumberModel updatePlumber(@NotNull Plumber model);

    PlumberModel findPlumber(@NotNull Long plumberOid);
}
