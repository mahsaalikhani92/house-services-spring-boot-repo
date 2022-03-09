package ir.maktab.houseservicesspringboot.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date offerSubmissionDate;
    private Double proposedPrice;
    private String workDuration;
    @Temporal(TemporalType.TIME)
    private Date startTime;
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;
    @ManyToOne
    @JoinColumn(name = "expert_id", nullable = false)
    private Expert expert;
}
