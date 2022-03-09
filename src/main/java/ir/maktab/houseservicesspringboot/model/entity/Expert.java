package ir.maktab.houseservicesspringboot.model.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mahsa Alikhani m-58
 */
@Setter
@Getter
@Entity
public class Expert extends User {
    @Lob
    @Column(unique = true, columnDefinition = "BLOB")
    private byte[] imageData;
    private Double meanRate;
    private Double credit;
    @ManyToMany
    private List<SubCategory> subCategories = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expert")
    private List<Offer> offers = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expert")
    private List<Comment> comments = new ArrayList<>();
}
