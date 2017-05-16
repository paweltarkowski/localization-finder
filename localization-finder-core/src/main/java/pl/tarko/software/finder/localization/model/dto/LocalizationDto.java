package pl.tarko.software.finder.localization.model.dto;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocalizationDto implements BaseDistributionDto {

    private static final long serialVersionUID = -615370954306444797L;

    private Long id;

    private String type;

    private CityDto city;

    private String address;

    private String zipCode;

    private Double latitude;

    private Double longitude;
}
