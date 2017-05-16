package pl.tarko.software.finder.localization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import pl.tarko.software.finder.localization.model.jpa.Localization;

public interface LocalizationRepository
        extends JpaRepository<Localization, Long>, QueryDslPredicateExecutor<Localization> {
}
