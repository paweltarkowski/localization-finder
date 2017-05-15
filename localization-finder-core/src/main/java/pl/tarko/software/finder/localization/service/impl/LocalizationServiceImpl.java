package pl.tarko.software.finder.localization.service.impl;

import org.springframework.stereotype.Service;
import pl.tarko.software.finder.localization.model.dto.LocalizationDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.model.jpa.Localization;
import pl.tarko.software.finder.localization.service.LocalizationService;

import java.util.Collections;
import java.util.List;

@Service
public class LocalizationServiceImpl extends CrudServiceImpl<LocalizationDto, Localization, Long> implements LocalizationService {

    @Override
    public List<LocalizationDto> findLocalizations(LocalizationSearchParamDto searchParams) {
        return mapper.mapAsList(repository.findAll(), LocalizationDto.class);
    }
}
