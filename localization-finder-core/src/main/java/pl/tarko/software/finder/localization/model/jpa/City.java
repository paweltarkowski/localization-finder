package pl.tarko.software.finder.localization.model.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "city_sequence", sequenceName = "city_id_seq", allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "city_sequence")
    private Long id;

    @Column
    @Setter
    private String name;

    @ManyToOne
    @Setter
    private Country country;

}
