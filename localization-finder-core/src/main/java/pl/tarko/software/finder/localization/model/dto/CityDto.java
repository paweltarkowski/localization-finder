package pl.tarko.software.finder.localization.model.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityDto implements BaseDistributionDto {

    private static final long serialVersionUID = -3389926032507218115L;

    private Long id;
    private String townName;
    private CountryDto country;
}