package pl.tarko.software.finder.lozalization.model.dto;

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

    private TownDto town;

    private String address;

    private Double latitude;

    private Double longitude;

    private String telNumber;
}
