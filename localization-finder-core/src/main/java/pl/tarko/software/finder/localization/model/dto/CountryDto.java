package pl.tarko.software.finder.localization.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryDto implements BaseDistributionDto{

    private Long id;
    private String name;
}
