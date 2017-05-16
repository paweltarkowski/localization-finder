package pl.tarko.software.finder.localization.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import pl.tarko.software.finder.CorePreConfiguredContextTest;
import pl.tarko.software.finder.localization.model.jpa.City;
import pl.tarko.software.finder.localization.model.jpa.Country;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

@Profile("test")
public class CityRepositoryTest extends CorePreConfiguredContextTest {

    @Autowired
    CityRepository testObject;

    @Autowired
    CountryRepository countryRepository;

    @Before
    public void setUp() {
        testObject.deleteAll();
        countryRepository.deleteAll();
    }

    @Test
    public void shouldNotFindAnyCity() {
        assertEquals(0, testObject.findAll().size());
    }

    @Test
    public void shouldFindCity() {
        System.out.println(new File(".").getAbsolutePath());
        // given
        List<City> cities = Arrays.asList(createCity("testCity", "testCountry"),
                createCity("testCityOther", "otherCountry"));
        for (City city : cities) {
            countryRepository.save(city.getCountry());
            testObject.save(city);
        }

        final Country country = countryRepository.findByName("testCountry");

        // when
        final List<City> result = testObject.findByNameIgnoreCaseContainingAndAndCountry_IdOrderByName("testCity", country.getId());

        // then
        Assert.assertEquals(1, result.size());
    }

    private City createCity(String cityName, String countryName) {
        Country country = Country.builder().name(countryName).build();
        City city = City.builder().name(cityName).country(country).build();
        return city;
    }
}
