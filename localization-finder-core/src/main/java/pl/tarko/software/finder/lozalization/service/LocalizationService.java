package pl.tarko.software.finder.lozalization.service;

import pl.tarko.software.finder.lozalization.model.dto.LocalizationDto;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.lozalization.model.jpa.Localization;

import java.util.List;

public interface LocalizationService extends CrudService<Localization, Long> {

    List<LocalizationDto> findLocalizations(LocalizationSearchParamDto searchParams);

}
