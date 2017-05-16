package pl.tarko.software.finder.localization.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CityDto implements BaseDistributionDto {

    private static final long serialVersionUID = -3389926032507218115L;

    private Long id;
    private String name;
    private CountryDto country;
}
