package pl.tarko.software.finder.lozalization.model.jpa;

import lombok.*;

import javax.persistence.*;

@Entity
@SequenceGenerator(name = "town_sequence", sequenceName = "town_id_seq", allocationSize = 1)
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Town {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "town_sequence")
    private Long id;

    @Column
    @Setter
    private String name;

    @ManyToOne
    @Setter
    private Country country;

}
