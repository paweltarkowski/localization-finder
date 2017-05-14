package pl.tarko.software.finder.lozalization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.tarko.software.finder.lozalization.model.jpa.Localization;

public interface LocalizationRepository
        extends JpaRepository<Localization, Long>/*
                                                     * , QueryDslPredicateExecutor<
													 * Localization>
													 */ {

}
