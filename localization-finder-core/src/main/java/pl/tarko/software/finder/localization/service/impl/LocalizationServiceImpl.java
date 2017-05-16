package pl.tarko.software.finder.localization.service.impl;

import org.springframework.stereotype.Service;
import pl.tarko.software.finder.localization.model.dto.CityDto;
import pl.tarko.software.finder.localization.model.dto.CountryDto;
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
        List<LocalizationDto> result = mapper.mapAsList(repository.findAll(), LocalizationDto.class);
        if(result.isEmpty()){
            LocalizationDto testObject = LocalizationDto.builder().id(1L).address("Test Address").city(CityDto.builder().country(CountryDto.builder().id(1L).name("Polska").build()).build()).latitude(11.22).longitude(33.33).build();
            result.add(testObject);
        }
        return result;
    }
}
