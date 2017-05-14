package pl.tarko.software.finder.lozalization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tarko.software.finder.lozalization.model.jpa.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);

}
