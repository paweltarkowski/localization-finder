package pl.tarko.software.finder.google.maps.service.impl;

import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import org.hsqldb.lib.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.tarko.software.finder.exceptions.GoogleLocalizationException;
import pl.tarko.software.finder.google.maps.service.GoogleLocalizationService;
import pl.tarko.software.finder.google.maps.util.LocalizationAdvancedGeoCoder;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;

import java.io.IOException;
import java.util.Optional;

@Service
public class GoogleLocalizationServiceImpl implements GoogleLocalizationService {

    private Logger logger = LoggerFactory.getLogger(GoogleLocalizationServiceImpl.class);

    private LocalizationAdvancedGeoCoder localizationGeoCoder;

    @Autowired
    public GoogleLocalizationServiceImpl(LocalizationAdvancedGeoCoder localizationGeoCoder) {
        this.localizationGeoCoder = localizationGeoCoder;
    }

    @Override
    public Optional<GeocoderResult> find(LocalizationSearchParamDto localizationSearchDto) throws GoogleLocalizationException {
        final String address = getGeoCoderSearchAddress(localizationSearchDto);
        final GeocoderRequest geoCoderRequest = new GeocoderRequestBuilder().setAddress(address).getGeocoderRequest();
        try {
            final GeocodeResponse response = localizationGeoCoder.geocode(geoCoderRequest);
            if (response.getResults() != null && response.getResults().size() > 0) {
                return Optional.of(response.getResults().get(0));
            }
        } catch (IOException e) {
            logger.error("Problem during geocode", e);
            throw new GoogleLocalizationException("Problem during geocode", e);
        }

        return Optional.empty();
    }

    private String getGeoCoderSearchAddress(LocalizationSearchParamDto localizationSearchDto) {
        final String streetSearch = (!StringUtil.isEmpty(localizationSearchDto.getStreet())
                ? localizationSearchDto.getStreet() + (StringUtil.isEmpty(localizationSearchDto.getBuildingNo())
                ? " " + localizationSearchDto.getBuildingNo() + ", " : "")
                : "");
        final String address = localizationSearchDto.getZipCode() + "," + localizationSearchDto.getCity() + ","
                + streetSearch + localizationSearchDto.getCountry();
        return address;
    }

}
