package pl.tarko.software.finder.lozalization.model.form;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LocalizationForm {
    private String zipCode;
    private String city;
    private String street;
    private String buildingNo;
    private String country;
}
