package pl.tarko.software.finder.localization.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocalizationSearchParamDto implements BaseDistributionDto {
    private static final long serialVersionUID = -4056963285638873102L;
    private String zipCode;
    private String city;
    private String street;
    private String buildingNo;
    private String country;
}
