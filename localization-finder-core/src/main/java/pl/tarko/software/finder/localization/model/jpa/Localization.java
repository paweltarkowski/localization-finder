package pl.tarko.software.finder.localization.model.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@SequenceGenerator(name = "localization_sequence", sequenceName = "localization_id_seq", initialValue = 1, allocationSize = 1)
public class Localization implements Serializable {

    private static final long serialVersionUID = -2688651231592263579L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localization_sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    private LocalizationType type = LocalizationType.DEFAULT;

    @ManyToOne
    @JoinColumn( name = "city_id")
    private City city;

    @Column
    private String street;

    @Column
    private String buildingNo;

    @Column
    private String zipCode;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

}
