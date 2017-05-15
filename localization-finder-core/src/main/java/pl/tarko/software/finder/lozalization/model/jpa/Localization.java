package pl.tarko.software.finder.lozalization.model.jpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@SequenceGenerator(name = "localization_sequence", sequenceName = "localization_id_seq", initialValue = 1, allocationSize = 1)
public class Localization implements Serializable {

    private static final long serialVersionUID = -2688651231592263579L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "localization_sequence")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Setter
    private LocatizationType type;

    @ManyToOne
    @Setter
    private Town town;

    @Column
    @Setter
    private String address;

    @Column
    @Setter
    private Double latitude;

    @Column
    @Setter
    private Double longitude;

    @Column
    @Setter
    private String telNumber;

}
