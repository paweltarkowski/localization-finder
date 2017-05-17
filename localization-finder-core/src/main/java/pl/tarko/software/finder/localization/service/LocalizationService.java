package pl.tarko.software.finder.localization.service;

import pl.tarko.software.finder.localization.model.dto.LocalizationDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.model.jpa.Localization;

import java.util.List;

public interface LocalizationService extends CrudService<Localization, Long> {

    List<LocalizationDto> findLocalizations(LocalizationSearchParamDto searchParams);

}
