package pl.tarko.software.finder.localization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tarko.software.finder.localization.model.jpa.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);

}
