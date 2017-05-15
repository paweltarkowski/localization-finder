package pl.tarko.software.finder.localization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tarko.software.finder.localization.model.jpa.Town;

import java.util.List;

public interface TownRepository extends JpaRepository<Town, Long> {

    List<Town> findByNameIgnoreCaseContainingAndAndCountry_IdOrderByName(String name, Long countryId);

}
