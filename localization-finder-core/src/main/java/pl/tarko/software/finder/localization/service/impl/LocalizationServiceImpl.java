package pl.tarko.software.finder.localization.service.impl;

import com.querydsl.core.BooleanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pl.tarko.software.finder.localization.model.dto.LocalizationDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.model.jpa.Localization;
import pl.tarko.software.finder.localization.model.jpa.QLocalization;
import pl.tarko.software.finder.localization.repository.LocalizationRepository;
import pl.tarko.software.finder.localization.service.LocalizationService;

import java.util.List;

@Service
public class LocalizationServiceImpl extends CrudServiceImpl<LocalizationDto, Localization, Long> implements LocalizationService {

    @Override
    public List<LocalizationDto> findLocalizations(LocalizationSearchParamDto searchParams) {
        QLocalization localization = QLocalization.localization;
        BooleanBuilder builder = new BooleanBuilder();

        if (StringUtils.hasText(searchParams.getCountry())) {
            builder.and(localization.city.country.name.equalsIgnoreCase(searchParams.getCountry()));
        }

        if (StringUtils.hasText(searchParams.getCity())) {
            builder.and(localization.city.name.startsWithIgnoreCase(searchParams.getCity()));
        }

        if (StringUtils.hasText(searchParams.getStreet())) {
            builder.and(localization.street.startsWithIgnoreCase(searchParams.getStreet()));
        }

        if (StringUtils.hasText(searchParams.getBuildingNo())) {
            builder.and(localization.buildingNo.eq(searchParams.getBuildingNo()));
        }

        if (StringUtils.hasText(searchParams.getZipCode())) {
            builder.and(localization.zipCode.eq(searchParams.getZipCode()));
        }

        List<LocalizationDto> result = mapper.mapAsList(((LocalizationRepository) repository).findAll(builder.getValue()), LocalizationDto.class);
        return result;
    }
}
