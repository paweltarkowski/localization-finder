package pl.tarko.software.finder.lozalization.model.jpa;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@SequenceGenerator(name = "country_sequence", sequenceName = "country_id_seq", initialValue = 1, allocationSize = 1)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country implements Serializable {

    private static final long serialVersionUID = -9046339688051050157L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_sequence")
    private Long id;

    @Setter
    private String name;

}
