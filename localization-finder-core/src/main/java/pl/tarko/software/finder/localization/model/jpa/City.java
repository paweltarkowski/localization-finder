package pl.tarko.software.finder.localization.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@SequenceGenerator(name = "city_sequence", sequenceName = "city_id_seq", allocationSize = 1)
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    private List<Localization> localizations;

}
