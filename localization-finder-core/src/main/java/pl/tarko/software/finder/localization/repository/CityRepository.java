package pl.tarko.software.finder.localization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tarko.software.finder.localization.model.jpa.City;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByNameIgnoreCaseContainingAndAndCountry_IdOrderByName(String name, Long countryId);

}
