package pl.tarko.software.finder.google.maps.service;

import com.google.code.geocoder.model.GeocoderResult;
import pl.tarko.software.finder.exceptions.GoogleLocalizationException;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;

import java.util.Optional;

public interface GoogleLocalizationService {

    Optional<GeocoderResult> find(LocalizationSearchParamDto localizationSearchDto) throws GoogleLocalizationException;
}
