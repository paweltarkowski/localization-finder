package pl.tarko.software.finder.google.maps.service.impl;

import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import pl.tarko.software.finder.CustomAssert;
import pl.tarko.software.finder.exceptions.GoogleLocalizationException;
import pl.tarko.software.finder.google.maps.util.LocalizationAdvancedGeoCoder;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.object.IsCompatibleType.typeCompatibleWith;
import static org.junit.Assert.*;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class GoogleLocalizationServiceImplTest {

    @Mock
    private LocalizationAdvancedGeoCoder localizationAdvancedGeoCoder;

    @InjectMocks
    private GoogleLocalizationServiceImpl testObject;

    @Test
    public void shouldGetEmptyObject() throws GoogleLocalizationException, IOException {
        // given
        when(localizationAdvancedGeoCoder.geocode(anyObject())).thenReturn(mock(GeocodeResponse.class));

        // when
        // then
        assertFalse("Result object should not exist ", testObject.find(LocalizationSearchParamDto.builder().build()).isPresent());
    }

    @Test
    public void shouldGetFirstResultFromList() throws GoogleLocalizationException, IOException {
        // given
        GeocodeResponse response = mock(GeocodeResponse.class);
        GeocoderResult resultFirst = createGeoCoderResult("FIRST");
        when(response.getResults())
                .thenReturn(Arrays.asList(resultFirst, createGeoCoderResult("SECOND"), createGeoCoderResult("THIRD")));

        when(localizationAdvancedGeoCoder.geocode(anyObject())).thenReturn(response);

        // when
        GeocoderResult result = testObject.find(LocalizationSearchParamDto.builder().build()).get();
        assertEquals(resultFirst.getFormattedAddress(), result.getFormattedAddress());
    }

    private GeocoderResult createGeoCoderResult(String formattedAddress) {
        GeocoderResult result = new GeocoderResult();
        result.setFormattedAddress(formattedAddress);
        return result;
    }

    @Test
    public void shouldCheckThrowException() throws GoogleLocalizationException, IOException {
        when(localizationAdvancedGeoCoder.geocode(anyObject())).thenThrow(new IOException("TEST"));
        Optional<Throwable> e = CustomAssert.assertThrown(() -> testObject.find(LocalizationSearchParamDto.builder().build()));

        assertThat(e.isPresent(), equalTo(true));
        assertThat(e.get().getClass(), typeCompatibleWith(GoogleLocalizationException.class));
    }
}
