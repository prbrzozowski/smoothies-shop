package pl.smoothiesshop.repository;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "smoothie_details")
@Getter
@Setter
public class SmoothieDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "smoothie_details_seq")
    @SequenceGenerator(name = "smoothie_details_seq")
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "smoothie_id", nullable = false)
    private Integer smoothieId;

    @Column(name = "name", nullable = false)
    private String name;

//    @Column(name = "value", nullable = false)
//    private String value;
//
    @Column(name = "description", nullable = false)
    private String description;
}