package pl.tarko.software.finder.lozalization.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CountryDto implements BaseDistributionDto{

    private Long id;
    private String name;
}
