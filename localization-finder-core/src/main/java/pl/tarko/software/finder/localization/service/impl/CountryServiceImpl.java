package pl.tarko.software.finder.localization.service.impl;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.tarko.software.finder.localization.model.dto.CountryDto;
import pl.tarko.software.finder.localization.model.jpa.Country;
import pl.tarko.software.finder.localization.service.CountryService;

import java.util.List;

@Service
public class CountryServiceImpl extends CrudServiceImpl<Country, Long> implements CountryService {

    @Override
    @Cacheable("countries")
    public List<CountryDto> findAll() {
        return mapper.mapAsList(repository.findAll(), CountryDto.class);
    }
}
