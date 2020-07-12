package co.anywhr.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author ntthuat
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(schema = "public", name = "hexagon")
@Builder
public class Hexagon extends BaseEntity {

    @Id
    @Column(name = "hexagon_id", columnDefinition = "serial")
    @GeneratedValue
    private Long hexagonId;

    @NaturalId
    @Column(name = "name", length = 64, nullable = false, unique = true)
    private String name;

    @Column(name = "coordinate_x", nullable = false)
    private Integer coordinateX;

    @Column(name = "coordinate_y", nullable = false)
    private Integer coordinateY;

    @Override
    public Long getId() {
        return hexagonId;
    }
}
