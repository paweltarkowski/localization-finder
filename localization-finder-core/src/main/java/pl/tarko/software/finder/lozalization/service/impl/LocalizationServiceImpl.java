package pl.tarko.software.finder.lozalization.service.impl;

import org.springframework.stereotype.Service;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationDto;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.lozalization.model.jpa.Localization;
import pl.tarko.software.finder.lozalization.service.LocalizationService;

import java.util.Collections;
import java.util.List;

@Service
public class LocalizationServiceImpl extends CrudServiceImpl<LocalizationDto, Localization, Long> implements LocalizationService {

    @Override
    public List<LocalizationDto> findLocalizations(LocalizationSearchParamDto searchParams) {
        //TODO change entity -> DTO
        return Collections.emptyList();
    }
}
