package pl.tarko.software.finder.lozalization.model.form;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;

@Setter
@Getter
public class LocalizationSearchParamForm {
    private String zipCode;
    @NotEmpty
    private String city;
    private String street;
    private String buildingNo;
    @NotEmpty
    private String country;
}
