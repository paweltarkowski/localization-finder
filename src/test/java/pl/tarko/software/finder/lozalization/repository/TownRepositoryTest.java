package pl.tarko.software.finder.lozalization.repository;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;

import pl.tarko.software.finder.PreconfiguredTransactionalTest;
import pl.tarko.software.finder.lozalization.model.jpa.Country;
import pl.tarko.software.finder.lozalization.model.jpa.Town;

@Profile("test")
public class TownRepositoryTest extends PreconfiguredTransactionalTest {

	@Autowired
	TownRepository testObject;

	@Autowired
	CountryRepository countryRepository;

	@Before
	public void setUp() {
		testObject.deleteAll();
		countryRepository.deleteAll();
	}

	@Test
	public void shouldNotFindAnyTown() {
		assertEquals(0, testObject.findAll().size());

	}

	@Test
	public void shouldFindTown() {
		// given
		List<Town> towns = Arrays.asList(createTown("testTown", "testCountry"),
				createTown("testTownOther", "otherCountry"));
		for (Town town : towns) {
			countryRepository.save(town.getCountry());
			testObject.save(town);
		}

		final Country country = countryRepository.findByName("testCountry");

		// when
		final List<Town> result = testObject.findByNameIgnoreCaseContainingAndAndCountry_IdOrderByName("testTown", country.getId());

		// then
		Assert.assertEquals(1, result.size());
	}

	private Town createTown(String townName, String countryName) {
		Country country = Country.builder().name(countryName).build();
		Town town = Town.builder().name(townName).country(country).build();
		return town;
	}
}
